package com.example.helpstudent.Service;

import com.example.helpstudent.Repository.TokenErrorRepository;
import com.example.helpstudent.registrierung.token.TokenError;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class TokenErrorService {
    private final TokenErrorRepository tokenerrorrepo;

    public TokenErrorService(TokenErrorRepository tokenerrorrepo) {
        this.tokenerrorrepo = tokenerrorrepo;
    }

    public void saveTokenErrortxt(TokenError e){
        tokenerrorrepo.save(e);
    }

    public String getTokenErrortxtbyToken(String token){
        if(tokenerrorrepo.findByToken(token).isPresent())
            return tokenerrorrepo.findByToken(token).get().getErrortxt();

        else
            return null;
    }
}
