package it.develhope.TimeBank.service;

import it.develhope.TimeBank.model.DTO.SignupActivationDTO;
import it.develhope.TimeBank.model.DTO.SignupDTO;
import it.develhope.TimeBank.model.entities.User;
import it.develhope.TimeBank.notification.MailNotificationService;
import it.develhope.TimeBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SignupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailNotificationService mailNotificationService;

    public User signup(SignupDTO signupDTO) throws Exception{
        User userFromDB = userRepository.findByEmail(signupDTO.getEmail());
        if (userFromDB != null)throw new Exception("User already exist");
        User user = new User();
        user.setName(signupDTO.getName());
        user.setSurname(signupDTO.getSurname());
        user.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
        user.setEmail(signupDTO.getEmail());
        user.setActivationCode(UUID.randomUUID().toString());
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
