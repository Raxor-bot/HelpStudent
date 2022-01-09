package com.example.helpstudent.registrierung.token;

import com.example.helpstudent.Tabellen.Student;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
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
            nullable = false
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
    
    public Student getStudent() {
    	return this.student;
    }

	public LocalDateTime getBestaetigtUm() {	
		return this.bestaetigtUm;
	}

	public LocalDateTime getVerfaelltUm() {
		return this.verfaelltUm;
	}
}
