package it.develhope.TimeBank.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import it.develhope.TimeBank.model.*;
import it.develhope.TimeBank.repository.RoleRepository;
import it.develhope.TimeBank.repository.UserRepository;
import it.develhope.TimeBank.utils.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // @Autowired
    // private MailNotificationService mailNotificationService;

    @Autowired
    private RoleRepository roleRepository;

    public static final String JWT_SECRET = "0813ec65-7824-4dbd-b13a-54bfbc99930b";

    public List<Role> generateRoles() {
        List<Role> roles = new ArrayList<>(Arrays.asList(
                new Role("REGISTERED"),
                new Role("ADMIN")
        ));
        // preparo una lista vuota dove inserire i ruoli che ho effettivamente inserito nel db
        List<Role> savedRoles = new ArrayList<>();
        for (Role role : roles) {
            // controllo se il ruolo in questione esiste già
            if(!roleRepository.findByName(role.getName()).isPresent()) {
                // se non esiste lo creo, e lo aggiungo alla lista di ruoli creati
                savedRoles.add(roleRepository.save(role));
            }
            // altrimenti non faccio niente - non c'è bisogno di un else
        }
        // restituisco la lista di ruoli creati
        return savedRoles;
    }

    public User signup(SignupDTO signupDTO) throws Exception{
        return this.signup(signupDTO, Roles.REGISTERED);
    }

    public User signup(SignupDTO signupDTO, String role) throws Exception {
        User userFromDB = userRepository.findByEmail(signupDTO.getEmail());
        if (userFromDB != null)throw new Exception("User already exist");
        User user = new User();
        user.setName(signupDTO.getName());
        user.setSurname(signupDTO.getSurname());
        user.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
        user.setEmail(signupDTO.getEmail());
        user.setActivationCode(UUID.randomUUID().toString());

        Set<Role> roles = new HashSet<>();
        Optional<Role> userRole = roleRepository.findByName(role.toUpperCase());
        if (!userRole.isPresent())throw new Exception("Role not found");
        roles.add(userRole.get());
        user.setRoles(roles);
        // mailNotificationService.sendActivationMail(user);
        return userRepository.save(user);
    }

    public User activate(String activationCode) throws Exception {
        User user = userRepository.findByActivationCode(activationCode);
        if (user == null) throw new Exception("User not found");
        user.setActive(true);
        user.setActivationCode(null);
        return userRepository.save(user);
    }

    public LoginRTO login(LoginDTO loginDTO){
        if(loginDTO == null) return null;
        User userFromDB = userRepository.findByEmail(loginDTO.getEmail());
        if(userFromDB == null || !userFromDB.isActive()) return null;

        boolean canLogin = passwordEncoder.matches(loginDTO.getPassword(), userFromDB.getPassword());
        if(!canLogin) return null;

        String JWT = generateJWT(userFromDB);

        userFromDB.setPassword(null);
        LoginRTO out = new LoginRTO();
        out.setJWT(JWT);
        out.setUser(userFromDB);

        return out;
    }

    //https://www.baeldung.com/java-date-to-localdate-and-localdatetime
    static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date
                .from(dateToConvert.atZone(ZoneId.systemDefault())
                        .toInstant());
    }

    public static String getJWT(User user){
        Date expiresAt = convertToDateViaInstant(LocalDateTime.now().plusDays(15));
        //https://mkyong.com/java8/java-8-how-to-convert-a-stream-to-array/
        String[] roles = user.getRoles().stream().map(role -> role.getName()).toArray(String[]::new);
        return JWT.create()
                .withIssuer("develhope-demo")
                .withIssuedAt(new Date())
                .withExpiresAt(expiresAt)
                .withClaim("roles", String.join(",", roles))
                .withClaim("id", user.getId())
                .sign(Algorithm.HMAC512(JWT_SECRET));

    }


    public String generateJWT(User user) {
        String JWT = getJWT(user);

        user.setJwtCreatedOn(LocalDateTime.now());
        userRepository.save(user);

        return JWT;
    }

}
