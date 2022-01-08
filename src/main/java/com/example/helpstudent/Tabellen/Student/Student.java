package com.example.helpstudent.Tabellen.Student;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long nlfdstudent;
    private String sname;
    private String svorname;
    private LocalDate geburtstag;
    private String geschlecht;
    private int nsemester;
    private String mail;
    private String passwort;
    private String bilderpfad;
    @Enumerated(EnumType.STRING)
    private StudentRolle rolle = StudentRolle.DEFAULT;
    private Boolean locked = false; //gebannt oder gesperrt
    private Boolean enabled = false; //Bestätigungslink in Bestätingungsmail geklickt (account verifiziert)


    public Student() {
    }

    public Student(String sname,        //Login Konstruktor
                   String svorname,
                   String mail,
                   String passwort) {
        this.sname = sname;
        this.svorname = svorname;
        this.mail = mail;
        this.passwort = passwort;
    }

    public Student(String sname,
                   String svorname,
                   LocalDate geburtstag,
                   int nsemester,
                   String mail,
                   String passwort,
                   String bilderpfad,
                   StudentRolle rolle) {
        this.sname = sname;
        this.svorname = svorname;
        this.geburtstag = geburtstag;
        this.nsemester = nsemester;
        this.mail = mail;
        this.passwort = passwort;
        this.bilderpfad = bilderpfad;
        this.rolle = rolle;
    }

    public Student(String sname,
                   String svorname,
                   LocalDate geburtstag,
                   int nsemester,
                   Studiengang studiengang,
                   String mail,
                   String passwort,
                   String bilderpfad,
                   StudentRolle rolle) {
        this.sname = sname;
        this.svorname = svorname;
        this.geburtstag = geburtstag;
        this.nsemester = nsemester;
        this.studiengang = studiengang;
        this.mail = mail;
        this.passwort = passwort;
        this.bilderpfad = bilderpfad;
        this.rolle = rolle;
    }

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Studiengang studiengang;

    @JsonIgnore
    @ManyToMany(mappedBy = "studentGruppen",cascade = CascadeType.ALL)
    List<Gruppe> gruppen;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority rang = new SimpleGrantedAuthority(rolle.name());
        return Collections.singletonList(rang);
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    } //Zu testzwecken erstmal unbeachtet

    public String getSname() {
        return sname;
    }

    public String getSvorname() {
        return svorname;
    }

    public LocalDate getGeburtstag() {
        return geburtstag;
    }

    public int getNsemester() {
        return nsemester;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String getPassword() {
        return passwort;
    }

    public String getBilderpfad() {
        return bilderpfad;
    }

    public StudentRolle getRolle() {
        return rolle;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    } // Ebenso zu testzwecken

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setBilderpfad(String bilderpfad) {
        this.bilderpfad = bilderpfad;
    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Fach> staerken;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Fach> schwaechen;


}