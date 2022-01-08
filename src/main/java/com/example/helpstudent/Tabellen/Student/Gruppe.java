package com.example.helpstudent.Tabellen.Student;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Gruppe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long iD;
    private int teilnehmeranzahl;
    private String gruppenname;

    public Gruppe(int teilnehmeranzahl, String gruppenname) {
        this.teilnehmeranzahl = teilnehmeranzahl;
        this.gruppenname = gruppenname;
    }

    public Gruppe(int teilnehmeranzahl, String gruppenname, Studiengang studiengang, Student erstelltvonnlfdstudent) {
        this.teilnehmeranzahl = teilnehmeranzahl;
        this.gruppenname = gruppenname;
        this.studiengang = studiengang;
        this.studentGruppen.add(erstelltvonnlfdstudent);
    }

    @ManyToOne
    private Studiengang studiengang;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    @JsonIgnore
    private List<Student> studentGruppen = new ArrayList<>();
    public Long getGruppenId() {
        return iD;
    }

    public void setGruppenId(Long gruppenId) {
        this.iD = gruppenId;
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
