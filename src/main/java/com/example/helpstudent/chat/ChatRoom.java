package com.example.helpstudent.chat;

import javax.persistence.*;


public class ChatRoom {
    @Id
    private String id;
    private String chatId;
    private String senderId;
    private String empfaengerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getEmpfaengerId() {
        return empfaengerId;
    }

    public void setEmpfaengerId(String empfaengerId) {
        this.empfaengerId = empfaengerId;
    }
}
