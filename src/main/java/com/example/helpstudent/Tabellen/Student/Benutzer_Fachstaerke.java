package com.example.helpstudent.Tabellen.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
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
    private long Student_nlfdStudent;
    private long fach_nlfdfach;
    private long stearke;

    public Benutzer_Fachstaerke(long student_nlfdStudent, long fach_nlfdfach, long stearke) {
        Student_nlfdStudent = student_nlfdStudent;
        this.fach_nlfdfach = fach_nlfdfach;
        this.stearke = stearke;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Fach fach;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    public Benutzer_Fachstaerke() {

    }
}
