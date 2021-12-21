package com.example.helpstudent.Tabellen.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Benutzer_Fachstaerke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long StudentenFachstaerkenEintrag;
    private long staerke;

    public Benutzer_Fachstaerke(long staerke){
        this.staerke = staerke;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Fach fach;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    public Benutzer_Fachstaerke() {

    }
}
