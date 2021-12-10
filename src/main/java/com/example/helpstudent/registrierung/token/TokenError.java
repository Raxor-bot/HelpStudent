package com.example.helpstudent.registrierung.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Getter
@Setter
@NoArgsConstructor
@Entity
public class TokenError{

    @Id
    @SequenceGenerator(
            name = "tokenerror_sequence",
            sequenceName = "tokenerror_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tokenerror_sequence"
    )
    private long id;
    private String token;
    private String errortxt;

    public TokenError(String t,String e) {
        this.token = t;
        this.errortxt = e;
    }
}
