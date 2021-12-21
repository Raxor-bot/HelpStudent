package com.example.helpstudent.Tabellen.Student;

import javax.persistence.*;

@Entity
@Table
public class Interessen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long nlfdInteressen;
    private String iName;

    

    public Interessen() {
    }

    public Interessen(String iName) {
        this.iName = iName;
    }

    public long getNlfdInteressen() {
        return nlfdInteressen;
    }

    public void setNlfdInteressen(long nlfdInteressen) {
        this.nlfdInteressen = nlfdInteressen;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }
}
