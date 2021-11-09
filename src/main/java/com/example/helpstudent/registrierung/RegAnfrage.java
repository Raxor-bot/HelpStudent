package com.example.helpstudent.registrierung;


import com.example.helpstudent.Tabellen.Student.StudentRolle;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegAnfrage {
    private final String sname;
    private final String svorname;
    private final LocalDate geburtstag;
    private final int nsemester;
    private final String mail;
    private final String passwort;
    private final String bilderpfad;
    private final StudentRolle rolle;

}
