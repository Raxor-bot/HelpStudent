package com.example.helpstudent.Tabellen;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "studiengang")
public class Studiengang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long studiengangid;
    private String stName;
    private String stAbkuerzung;

    public Studiengang() {

    }

    public Studiengang(String name, String abkuerzung, List<Fach> fachListe) {
        this.stName = name;
        this.setStAbkuerzung(abkuerzung);
        this.faecher = fachListe;
    }

    public String getStName() {
        return stName;
    }

    public Studiengang(String stName){
        this.stName = stName;
    }
    public Studiengang(String stName, String stAbkuerzung){
        this.stName = stName;
        this.setStAbkuerzung(stAbkuerzung);
    }
    public Studiengang(String stName, List<Fach> fachList) {
            this.stName = stName;
            this.faecher = fachList;
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

	public String getStAbkuerzung() {
		return stAbkuerzung;
	}

	public void setStAbkuerzung(String stAbkuerzung) {
		this.stAbkuerzung = stAbkuerzung;
	}
}
