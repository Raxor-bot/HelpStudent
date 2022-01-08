package com.example.helpstudent.Service;

import com.example.helpstudent.Repository.BestaetigungsTokenRepository;
import com.example.helpstudent.registrierung.token.BestaetigungsToken;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Getter

public class BestaetigungsTokenService {
    private final BestaetigungsTokenRepository bestaetrepo;

    public BestaetigungsTokenService(BestaetigungsTokenRepository bestaetrepo) {
        this.bestaetrepo = bestaetrepo;
    }

    public void saveBestaetigungsToken(BestaetigungsToken token){
        bestaetrepo.save(token);
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
