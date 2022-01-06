package com.example.helpstudent.Tabellen.Student;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="fach")
public class Fach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nlfdFach;
    private String fachName;
    private int semester;

   // @ManyToMany(mappedBy = "faecher")
    //private List<Studiengang> stdList;
    public Fach(String fachName, int semester) {
        this.fachName = fachName;
        this.semester = semester;
    }


    public Fach() {

    }

}
