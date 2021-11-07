package com.example.helpstudent.Tabellen.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Studiengang {
    @Id
    @SequenceGenerator(
            name = "Studiengang_sequence",
            sequenceName = "Studiengang_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Studiengang"
    )

    private long nlfdstudiengang;
    private String stName;

    public Studiengang(String stName){
        this.stName = stName;
    }

    public Studiengang() {

    }

    @ManyToOne(cascade=CascadeType.ALL)
    private Student student;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Fach> fachList;
}
