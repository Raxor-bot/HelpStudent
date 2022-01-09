package com.example.helpstudent.Tabellen;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Fach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long nlfdFach;
    private String fachName;
    private int semester;

    public Fach(String fachName, int semester) {
        this.setFachName(fachName);
        this.setSemester(semester);
    }

    public Fach() {

    }

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getFachName() {
		return fachName;
	}

	public void setFachName(String fachName) {
		this.fachName = fachName;
	}
}
