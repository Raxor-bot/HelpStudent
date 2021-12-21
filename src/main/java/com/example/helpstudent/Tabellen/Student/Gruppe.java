package com.example.helpstudent.Tabellen.Student;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Gruppe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long gruppenId;
    private int teilnehmeranzahl;
    private String gruppenname;
    private Long studentenId;


    public Gruppe(int teilnehmeranzahl, String gruppenname) {
        this.teilnehmeranzahl = teilnehmeranzahl;
        this.gruppenname = gruppenname;
    }

    public Gruppe() {

    }

    @ManyToOne
    private Studiengang studiengang;




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
