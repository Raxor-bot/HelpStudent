package com.example.helpstudent.Service;

import com.example.helpstudent.Repository.TokenErrorRepository;
import com.example.helpstudent.registrierung.token.TokenError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor
public class TokenErrorService {
    private final TokenErrorRepository tokenerrorrepo;

    public void saveTokenErrortxt(TokenError e){
        tokenerrorrepo.save(e);
    }

    public String getTokenErrortxtbyToken(String token){
       return tokenerrorrepo.findByToken(token).get().getErrortxt();
    }
}
