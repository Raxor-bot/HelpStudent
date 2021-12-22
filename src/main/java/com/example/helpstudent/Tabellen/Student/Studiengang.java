package com.example.helpstudent.Tabellen.Student;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Studiengang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studiengang_id", nullable = false)
    private Long studiengangid;

    public String getStName() {
        return stName;
    }

    private String stName;

    public Studiengang(String stName){
        this.stName = stName;
    }

    public Studiengang() {

    }

    @OneToMany(cascade =  CascadeType.ALL,
               mappedBy = "studiengang")
    private List<Student> students;

    @ManyToMany
    private List<Fach> faecher;

    public Long getStudiengangid() {
        return studiengangid;
    }

    public void setStudiengangid(Long studiengangid) {
        this.studiengangid = studiengangid;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Fach> getFaecher() {
        return faecher;
    }

    public void setFaecher(List<Fach> faecher) {
        this.faecher = faecher;
    }
}
