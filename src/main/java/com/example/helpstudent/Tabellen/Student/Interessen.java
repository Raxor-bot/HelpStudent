package com.example.helpstudent.Tabellen.Student;

import javax.persistence.*;

@Entity
@Table
public class Interessen {
    @Id
    @SequenceGenerator(
            name = "Interessen_sequence",
            sequenceName = "Interessen_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Interessen"
    )

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
