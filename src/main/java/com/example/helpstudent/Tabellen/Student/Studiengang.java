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

    private String stName;

    public Studiengang(String stName){
        this.stName = stName;
    }

    public Studiengang() {

    }

    @OneToMany(cascade =  CascadeType.ALL,
               mappedBy = "studiengang")
    private List<Student> students;

    public Long getStudiengangid() {
        return studiengangid;
    }

    public void setStudiengangid(Long studiengangid) {
        this.studiengangid = studiengangid;
    }


}
