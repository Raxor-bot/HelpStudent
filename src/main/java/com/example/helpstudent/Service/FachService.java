package com.example.helpstudent.Service;

import com.example.helpstudent.Repository.FachRepository;
import com.example.helpstudent.Tabellen.Student.Fach;
import com.example.helpstudent.Tabellen.Student.Studiengang;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FachService{
       private final FachRepository fachRepository;

       public FachService(FachRepository fachRepository) {
        this.fachRepository = fachRepository;
       }

    public void saveAll(List<Fach> fachListe) {
           fachRepository.saveAll(fachListe);
    }

    public Fach getFachByName(String name){
          return fachRepository.getFachByFachName(name);
       }

    public List<Fach> getAllFaecher(){
        return fachRepository.findAll();
    }

}
