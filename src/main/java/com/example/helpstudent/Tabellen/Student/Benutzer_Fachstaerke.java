package com.example.helpstudent.Tabellen.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "benutzer_fachstaerke")
public class Benutzer_Fachstaerke {
    @Id
    @SequenceGenerator(
            name = "Fach_sequence",
            sequenceName = "Fach_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Fach"
    )

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
