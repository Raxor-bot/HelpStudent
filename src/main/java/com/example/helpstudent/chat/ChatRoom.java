package com.example.helpstudent.chat;

import com.example.helpstudent.Tabellen.Student.ChatMessage;
import com.example.helpstudent.Tabellen.Student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chatRoom")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long chatRoomid;


    @OneToMany
    private List<ChatMessage> nachrichten;

    @OneToOne
    private Student sender;

    @OneToOne
    private Student empfaenger;


    public Student getEmpfaenger() {
        return empfaenger;
    }

    public Student getSender() {
        return sender;
    }

    public void setEmpfaenger(Student empfaenger) {
        this.empfaenger = empfaenger;
    }

    public void setSender(Student sender) {
        this.sender = sender;
    }

    public Long getChatRoomid() {
        return chatRoomid;
    }

    public void setChatRoomid(Long chatRoomid) {
        this.chatRoomid = chatRoomid;
    }

    public List<ChatMessage> getNachrichten() {
        return nachrichten;
    }

    public void setNachrichten(List<ChatMessage> nachrichten) {
        this.nachrichten = nachrichten;
    }
}
