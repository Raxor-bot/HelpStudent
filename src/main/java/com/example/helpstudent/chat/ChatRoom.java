package com.example.helpstudent.chat;

import com.example.helpstudent.Tabellen.Student.ChatMessage;
import com.example.helpstudent.Tabellen.Student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chatRoom")
public class ChatRoom {

    @Id
    @SequenceGenerator(
            name = "chatRoom_sequence",
            sequenceName = "chatRoom_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "chatRoom_sequence"
    )


    private Long chatRoomid;


    @OneToMany
    private List<ChatMessage> nachrichten;

    @OneToOne
    private Student sender;

    @OneToOne
    private Student empfaenger;




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
