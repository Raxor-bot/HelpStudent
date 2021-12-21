package com.example.helpstudent.registrierung.token;

import com.example.helpstudent.Tabellen.Student.Student;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BestaetigungsToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long bestaetigungsTokenid;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime erstelltUm;

    private LocalDateTime verfaelltUm;

    private LocalDateTime bestaetigtUm;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "nlfdstudent"
    )
    private Student student;
    public BestaetigungsToken(String token,
                              LocalDateTime erstelltUm,
                              LocalDateTime verfaelltUm,
                              Student student) {
        this.token = token;
        this.erstelltUm = erstelltUm;
        this.verfaelltUm = verfaelltUm;
        this.student = student;
    }
}
