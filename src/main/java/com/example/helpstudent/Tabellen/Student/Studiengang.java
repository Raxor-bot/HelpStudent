package com.example.helpstudent.Tabellen.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Studiengang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long nlfdstudiengang;
    private String stName;

    public Studiengang(String stName){
        this.stName = stName;
    }

    public Studiengang() {

    }


}
