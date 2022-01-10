package com.example.helpstudent.Tabellen;


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

    private long id;
    private String gruppenname;

    public Gruppe(String gruppenname) {
        this.gruppenname = gruppenname;
    }

    public Gruppe(String gruppenname, Fach fach, Student erstelltvonnlfdstudent) {
        this.gruppenname = gruppenname;
        this.fach = fach;
        this.studentGruppen.add(erstelltvonnlfdstudent);
    }

    @ManyToOne
    private Fach fach;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    @JsonIgnore
    private List<Student> studentGruppen = new ArrayList<>();
    public Long getGruppenId() {
        return id;
    }

    public void setGruppenId(Long gruppenId) {
        this.id = gruppenId;
    }

    public String getGruppenname() {
        return gruppenname;
    }

    public void setGruppenname(String gruppenname) {
        this.gruppenname = gruppenname;
    }
}
