package com.example.SignupApi.service;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class EmailSender {

    public static void Send(String recipientEmail) {

        final String username = "harshitksevkani7777@gmail.com";
        final String password = "dnzssmhbcyckojsr";

        String to = recipientEmail;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            message.setSubject("SignUp Successful");

            message.setText("Your account is created Successfully");

            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            if (e instanceof javax.mail.SendFailedException) {
                javax.mail.SendFailedException sfex = (javax.mail.SendFailedException) e;
                javax.mail.Address[] invalid = sfex.getInvalidAddresses();
                if (invalid != null) {
                    for (javax.mail.Address address : invalid) {
                        System.out.println("Invalid address: " + address);
                    }
                }
            } else {
                throw new RuntimeException(e);
            }
        }
    }
}