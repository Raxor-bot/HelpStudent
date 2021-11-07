package com.example.helpstudent.Tabellen.Student;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    private long nlfdbenutzer;
    private String sname;
    private String svorname;
    private LocalDate geburtstag;
    private int nsemester;
    private String mail;
    private String passwort;
    private String bilderpfad;



    public Student() {
    }

    public Student(String sname, String svorname, LocalDate geburtstag, int nsemester, String mail, String passwort, String bilderpfad) {
        this.sname = sname;
        this.svorname = svorname;
        this.geburtstag = geburtstag;
        this.nsemester = nsemester;
        this.mail = mail;
        this.passwort = passwort;
        this.bilderpfad = bilderpfad;
    }

    public long getNlfdbenutzer() {
        return nlfdbenutzer;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSvorname() {
        return svorname;
    }

    public void setSvorname(String svorname) {
        this.svorname = svorname;
    }

    public LocalDate getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(LocalDate geburtstag) {
        this.geburtstag = geburtstag;
    }

    public int getNsemester() {
        return nsemester;
    }

    public void setNsemester(int nsemester) {
        this.nsemester = nsemester;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getBilderpfad() {
        return bilderpfad;
    }

    public void setBilderpfad(String bilderpfad) {
        this.bilderpfad = bilderpfad;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nlfdbenutzer=" + nlfdbenutzer +
                ", sname='" + sname + '\'' +
                ", svorname='" + svorname + '\'' +
                ", geburtstag=" + geburtstag +
                ", nsemester=" + nsemester +
                ", mail='" + mail + '\'' +
                ", passwort='" + passwort + '\'' +
                ", bilderpfad='" + bilderpfad + '\'' +
                '}';
    }

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Interessen> interessen;
}