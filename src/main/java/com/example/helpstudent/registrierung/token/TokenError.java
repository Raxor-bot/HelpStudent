package com.example.helpstudent.registrierung.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Component
public class TokenError extends BestaetigungsToken{

    @Id
    @SequenceGenerator(
            name = "tokenerror_sequence",
            sequenceName = "tokenerror_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TokenError"
    )
    private long id;
    @JoinColumn(
            nullable = false,
            name = "token"
    )
    private String token;
    private String errortxt;

    public TokenError(String t,String e) {
        this.token = t;
        this.errortxt = e;
    }
}
