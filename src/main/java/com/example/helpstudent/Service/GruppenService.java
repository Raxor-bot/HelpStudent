package com.example.helpstudent.Service;

import com.example.helpstudent.Repository.GruppenRepository;
import com.example.helpstudent.Tabellen.Student.Gruppe;
import com.example.helpstudent.Tabellen.Student.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GruppenService{


    private final GruppenRepository repo;

    public GruppenService(GruppenRepository repo) {
        this.repo = repo;
    }


    public List<Gruppe> getGruppen(){
        return repo.findAll();
    }

    public void addNewGruppe(Gruppe gruppe){
        Optional<Gruppe> gruppeOptional = repo.findByGruppenname(gruppe.getGruppenname());
        if (gruppeOptional.isPresent()){
            throw new IllegalStateException("Gruppe ist bereits vorhanden!");
        }
        repo.save(gruppe);

    }

}