package com.example.helpstudent.Service;

import com.example.helpstudent.Repository.BestaetigungsTokenRepository;
import com.example.helpstudent.registrierung.token.BestaetigungsToken;
import com.example.helpstudent.registrierung.token.TokenError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Getter
@AllArgsConstructor
public class BestaetigungsTokenService {
    private final BestaetigungsTokenRepository bestaetrepo;

    public void saveBestaetigungsToken(BestaetigungsToken token){
        bestaetrepo.save(token);
    }

    public void saveTokenError(TokenError e){
        bestaetrepo.save(e);
    }

    public Optional<BestaetigungsToken> getToken(String token) {
        return bestaetrepo.findByToken(token);
    }

    public long getStudentIDbyToken(String token){
        return bestaetrepo.findByToken(token).get().getStudent().getNlfdstudent();
    }

    public int setConfirmedAt(String token) {
        return bestaetrepo.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
