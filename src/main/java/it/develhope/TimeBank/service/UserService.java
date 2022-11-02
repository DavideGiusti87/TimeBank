package it.develhope.TimeBank.service;

import it.develhope.TimeBank.model.User;
import it.develhope.TimeBank.repository.UserRepository;
import it.develhope.TimeBank.utils.MailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
