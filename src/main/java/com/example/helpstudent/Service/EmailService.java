package com.example.helpstudent.Service;

import com.example.helpstudent.registrierung.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service

public class EmailService implements EmailSender {

    private final static Logger LOGGER = LoggerFactory
            .getLogger(EmailService.class);

    private final JavaMailSender mailsender;

    public EmailService(JavaMailSender mailsender) {
        this.mailsender = mailsender;
    }

    @Override
    @Async
    public void send(String to, String email) {
        try{
            MimeMessage msg = mailsender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg,"utf-8");
            helper.setText(email,true);
            helper.setTo(to);
            helper.setSubject("HelpStudents E-mail Bestätigen");
            helper.setFrom(new InternetAddress("helpstudents@linusu.de"));
            mailsender.send(msg);
        } catch (MessagingException e) {
            LOGGER.error("Nachricht konnte nicht gesendet werden", e);
            throw new IllegalStateException("failed to send email");
        }
    }
}
