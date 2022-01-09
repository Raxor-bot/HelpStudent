package com.example.helpstudent.Tabellen;


public class ChatMessage {

        private String nachricht;
        private String sender;
        private String empfaenger;
        private ChatType typ;


        public String getNachricht() {
                return nachricht;
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
