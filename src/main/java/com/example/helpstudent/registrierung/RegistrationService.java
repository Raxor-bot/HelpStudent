package com.example.helpstudent.registrierung;

import com.example.helpstudent.Service.BestaetigungsTokenService;
import com.example.helpstudent.Service.StudentService;
import com.example.helpstudent.Tabellen.Student.Student;
import com.example.helpstudent.registrierung.token.BestaetigungsToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final StudentService studentService;
    private final EmailValidierung emailValidierung;
    private final BestaetigungsTokenService bestaetigungsTokenService;

public String registrieren(RegAnfrage anfrage){
    boolean isValidEmail = emailValidierung.test(anfrage.getMail());
    if(!isValidEmail){
        throw new IllegalStateException("Email nicht Gültig");
    }
    return studentService.addNewStudent(
            new Student(
                    anfrage.getSname(),
                    anfrage.getSvorname(),
                    anfrage.getGeburtstag(),
                    anfrage.getNsemester(),
                    anfrage.getMail(),
                    anfrage.getPasswort(),
                    anfrage.getBilderpfad(),
                    anfrage.getRolle()));
}
@Transactional
public String bestaetigeToken(String token){
    BestaetigungsToken bestaetigungsToken = bestaetigungsTokenService
            .getToken(token).
            orElseThrow(() -> new IllegalStateException("Token nicht gefunden"));

    if(bestaetigungsToken.getBestaetigtUm() != null){
        throw new IllegalStateException("Token wurde schon bestaetigt!");
    }

    LocalDateTime verfallenUm = bestaetigungsToken.getVerfaelltUm();

    if(verfallenUm.isBefore(LocalDateTime.now())){
        throw new IllegalStateException("Token abgelaufen!");
    }

    bestaetigungsTokenService.setConfirmedAt(token);
    studentService.enableStudent(bestaetigungsToken.getStudent().getMail());

    return "bestaetigt";
}
}
