package com.example.helpstudent.chat;

import org.springframework.data.annotation.Id;

import java.util.Date;


public class ChatMessage {
        @Id
        private String id;
        private String chatroomId;
        private String senderId;
        private String empfaengerId;
        private String senderName;
        private String empfaengerName;
        private String nachricht;








}
