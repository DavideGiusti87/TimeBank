package it.develhope.TimeBank.utils;

import it.develhope.TimeBank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class MailNotificationService {

    @Autowired
    JavaMailSender mailSender;

    public void sendActivationMail(User user) throws MessagingException {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setFrom("XXXX@gmail.com");
        message.setSubject("Ti sei iscritto alla piattaforma");
        message.setText("Il codice di attivazione è: " + user.getActivationCode());
        mailSender.send(message);
        /*
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        mimeMessage.setFrom("????????");
        mimeMessage.addRecipients(Message.RecipientType.TO,user.getEmail());
        mimeMessage.setSubject("Ti sei iscritto alla piattaforma");
        mimeMessage.setContent("Il codice di attivazione è: " + user.getActivationCode(),"text/html");
        mailSender.send(mimeMessage);
         */
    }




}
