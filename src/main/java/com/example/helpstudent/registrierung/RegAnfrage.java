package com.example.helpstudent.registrierung;


import com.example.helpstudent.Tabellen.Student.StudentRolle;
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
    private  String bilderpfad;
    private  StudentRolle rolle;

    public RegAnfrage() {

    }
}
