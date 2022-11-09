package it.develhope.TimeBank.service;

import it.develhope.TimeBank.model.User;
import it.develhope.TimeBank.repository.UserRepository;
import it.develhope.TimeBank.utils.MailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MailNotificationService mailNotificationService;

    private User anonymousUser = null;

    public User getAnonymousUser() {
        // lazy initialization of singleton anonymous user
        if (anonymousUser == null) {
            anonymousUser = userRepository.save(new User());
            anonymousUser.setUsername("Anonymous");

        }
        return anonymousUser;
    }


    public User updateUser(User user, User updatedUser) {
        user.setName(updatedUser.getName());
        user.setSurname(updatedUser.getSurname());
        user.setUsername(updatedUser.getUsername());
        user.setTelephoneNumber(updatedUser.getTelephoneNumber());
        user.setEmail(updatedUser.getEmail());
        user.setArea(updatedUser.getArea());
        user.setSkills(updatedUser.getSkills());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public String deleteById(User user) {
        userRepository.delete(user);
        return "Your account has been successfully deleted!";
    }
}
