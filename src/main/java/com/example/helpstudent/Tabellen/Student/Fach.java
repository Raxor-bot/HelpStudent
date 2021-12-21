package com.example.helpstudent.Tabellen.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Fach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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
