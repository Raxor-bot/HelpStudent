package com.example.helpstudent.registrierung;

import org.springframework.stereotype.Component;

@Component
public interface EmailSender {
    void send(String to, String email);
}
