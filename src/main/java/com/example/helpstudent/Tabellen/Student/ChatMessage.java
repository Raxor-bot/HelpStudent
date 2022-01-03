package com.example.helpstudent.Tabellen.Student;



import com.example.helpstudent.Tabellen.Student.Student;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


public class ChatMessage {

        private String nachricht;
        private String sender;
        private String empfaenger;
        private ChatType typ;

        public ChatType getTyp() {
                return typ;
        }

        public void setTyp(ChatType typ) {
                this.typ = typ;
        }

        public String getNachricht() {
                return nachricht;
        }

        public void setNachricht(String nachricht) {
                this.nachricht = nachricht;
        }

        public String getSender() {
                return sender;
        }

        public void setSender(String sender) {
                this.sender = sender;
        }

        public String getEmpfaenger() {
                return empfaenger;
        }

        public void setEmpfaenger(String empfaenger) {
                this.empfaenger = empfaenger;
        }
}
