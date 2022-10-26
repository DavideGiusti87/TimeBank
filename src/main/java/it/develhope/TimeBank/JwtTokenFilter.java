package it.develhope.TimeBank;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import it.develhope.TimeBank.model.entities.User;
import it.develhope.TimeBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {


    @Autowired
    private UserRepository userRepository;

    private Collection<? extends GrantedAuthority> getAuthorities(User user){
        if(user == null || !user.isActive()) return List.of();
        return user.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role.getName())).toList();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        //Get Authorization header and validate him
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null) {
            filterChain.doFilter(request, response);
            return;
        }
        //Get Jwt Token and validate
        final String token;
        try{
            token = header.split(" ")[1].trim();
        }catch (JWTVerificationException ex){
            filterChain.doFilter(request, response);
            return;
        }
        DecodedJWT decodedJWT;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512("0813ec65-7824-4dbd-b13a-54bfbc99930b")).withIssuer("develhope-demo").build();
            decodedJWT = verifier.verify(token);
        }catch (JWTVerificationException ex){
            filterChain.doFilter(request, response);
            return;
        }
        // Get user identity and set it on the spring security context
        Optional<User> userDetails = userRepository.findById(decodedJWT.getClaim("id").asLong());
        if (!userDetails.isPresent() || !userDetails.get().isActive()) {
            filterChain.doFilter(request, response);
            return;
        }

        User user = userDetails.get();
        user.setPassword(null);
        user.setActivationCode(null);
        user.setPasswordResetCode(null);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                user, null, getAuthorities(user)
        );

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }


}
