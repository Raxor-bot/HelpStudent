package com.example.helpstudent.registrierung;


import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegAnfrage {
    private String sname;
    private  String svorname;
    private  LocalDate geburtstag;
    private  int nsemester;
    private  String mail;
    private  String passwort;

    public RegAnfrage() {}
}
