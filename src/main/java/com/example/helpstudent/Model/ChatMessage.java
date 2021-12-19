package com.example.helpstudent.Model;



import com.example.helpstudent.Tabellen.Student.Student;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table()
public class ChatMessage {

        @Id
        @SequenceGenerator(
                name = "chatMessage_sequence",
                sequenceName = "chatMessage_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "chatMessage_sequence"
        )

        private Long chatId;


        private String nachricht;

        public Long getChatId() {
                return chatId;
        }

        public void setChatId(Long chatId) {
                this.chatId = chatId;
        }
}
