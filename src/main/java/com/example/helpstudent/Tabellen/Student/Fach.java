package com.example.helpstudent.Tabellen.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Fach {
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

    private long nlfdFach;
    private String fachName;
    private int semester;

    public Fach(String fachName, int semester) {
        this.fachName = fachName;
        this.semester = semester;
    }


    public Fach() {

    }

}
