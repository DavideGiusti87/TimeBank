package it.develhope.TimeBank.service;

import it.develhope.TimeBank.model.DTO.SignupActivationDTO;
import it.develhope.TimeBank.model.DTO.SignupDTO;
import it.develhope.TimeBank.model.entities.Role;
import it.develhope.TimeBank.model.entities.User;
import it.develhope.TimeBank.notification.MailNotificationService;
import it.develhope.TimeBank.repository.RoleRepository;
import it.develhope.TimeBank.repository.UserRepository;
import it.develhope.TimeBank.utils.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class SignupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailNotificationService mailNotificationService;

    @Autowired
    private RoleRepository roleRepository;

    public User signup(SignupDTO signupDTO) throws Exception{
        return this.signup(signupDTO, Roles.REGISTERED);
    }

    public User signup(SignupDTO signupDTO, String role) throws Exception{
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
        mailNotificationService.sendActivationMail(user);
        return userRepository.save(user);
    }

    public User activate(SignupActivationDTO signupActivationDTO) throws Exception {
        User user = userRepository.findByActivationCode(signupActivationDTO.getActivationCode());
        if (user == null)throw new Exception("User not found");
        user.setActive(true);
        user.setActivationCode(null);
        return userRepository.save(user);
    }
}
