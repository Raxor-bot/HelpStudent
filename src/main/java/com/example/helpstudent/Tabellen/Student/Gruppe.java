package com.example.helpstudent.Tabellen.Student;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Gruppe {
    @Id
    @SequenceGenerator(
            name = "Gruppe_sequence",
            sequenceName = "Gruppe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Gruppe"
    )


    private Long gruppenId;
    private int teilnehmeranzahl;
    private String gruppenname;
    private Long studentenId;


    public Gruppe(int teilnehmeranzahl, String gruppenname, Long studentenId) {
        this.teilnehmeranzahl = teilnehmeranzahl;
        this.gruppenname = gruppenname;
        this.studentenId = studentenId;
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

    public Long getStudentenId() {
        return studentenId;
    }

    public void setStudentenId(Long studentenId) {
        this.studentenId = studentenId;
    }
}
