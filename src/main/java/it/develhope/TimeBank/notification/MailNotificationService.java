package it.develhope.TimeBank.notification;

import it.develhope.TimeBank.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailNotificationService {

    @Autowired
    JavaMailSender mailSender;

    public void sendActivationMail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setFrom("??????????");
        message.setSubject("Ti sei iscritto alla piattaforma");
        message.setText("Il codice di attivazione è: " + user.getActivationCode());
        mailSender.send(message);
    }




}
