package com.example.helpstudent.Student;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private String vorname;
    private String name;
    private String email;
    private LocalDate gebDatum;

    public Student(String vorname, String name, String email, LocalDate gebDatum) {
        this.vorname = vorname;
        this.name = name;
        this.email = email;
        this.gebDatum = gebDatum;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getGebDatum() {
        return gebDatum;
    }

    public void setGebDatum(LocalDate gebDatum) {
        this.gebDatum = gebDatum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", vorname='" + vorname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gebDatum=" + gebDatum +
                '}';
    }
}
