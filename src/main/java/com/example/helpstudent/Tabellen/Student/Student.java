package com.example.helpstudent.Tabellen.Student;


import com.example.helpstudent.chat.ChatRoom;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student implements UserDetails {
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

    private long nlfdstudent;
    private String sname;
    private String svorname;
    private LocalDate geburtstag;
    private int nsemester;
    private String mail;
    private String passwort;
    private String bilderpfad;
    @Enumerated(EnumType.STRING)
    private StudentRolle rolle = StudentRolle.USER;
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

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Interessen> interessen;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority rang = new SimpleGrantedAuthority(rolle.name());
        return Collections.singletonList(rang);
    }

    @Override
    public String getPassword() {
        return passwort;
    }

    @Override
    public String getUsername() {
        return svorname;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    } //Zu testzwecken erstmal unbeachtet

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


}