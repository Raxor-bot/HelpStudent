package com.example.helpstudent.Tabellen.Student;


import com.example.helpstudent.Service.StudiengangService;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Gruppe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long gruppenId;
    private int teilnehmeranzahl;
    private String gruppenname;

    @ManyToMany
    private List<Student> studentenListe;


    public Gruppe(int teilnehmeranzahl, String gruppenname) {
        this.teilnehmeranzahl = teilnehmeranzahl;
        this.gruppenname = gruppenname;
    }

    public Gruppe(int teilnehmeranzahl, String gruppenname,Studiengang studiengang, Student erstelltvonnlfdstudent) {
        this.teilnehmeranzahl = teilnehmeranzahl;
        this.gruppenname = gruppenname;
       this.studiengang = studiengang;
        this.student = erstelltvonnlfdstudent;
    }

    @ManyToOne
    private Studiengang studiengang;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "nlfdstudent"
    )
    private Student student;

    public Long getGruppenId() {
        return gruppenId;
    }

    public void setGruppenId(Long gruppenId) {
        this.gruppenId = gruppenId;
    }

    public int getTeilnehmeranzahl() {
        return teilnehmeranzahl;
    }

    public void setTeilnehmeranzahl(int teilnehmeranzahl) {
        this.teilnehmeranzahl = teilnehmeranzahl;
    }

    public String getGruppenname() {
        return gruppenname;
    }

    public void setGruppenname(String gruppenname) {
        this.gruppenname = gruppenname;
    }
}
