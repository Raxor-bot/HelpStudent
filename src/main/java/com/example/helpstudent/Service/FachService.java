package com.example.helpstudent.Service;

import com.example.helpstudent.Repository.FachRepository;
import com.example.helpstudent.Tabellen.Fach;
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

    public Fach getFachById(long id){
           return fachRepository.getFachByNlfdFach(id);
    }
}
