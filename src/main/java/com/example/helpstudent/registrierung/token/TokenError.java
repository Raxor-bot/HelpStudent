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
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long tokenErrorid;
    private String token;
    private String errortxt;

    public TokenError(String t,String e) {
        this.setToken(t);
        this.errortxt = e;
    }

	public String getErrortxt() {
		return errortxt;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
