package com.example.helpstudent.Service;

import com.example.helpstudent.Repository.GruppenRepository;
import com.example.helpstudent.Tabellen.Student.Gruppe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GruppenService{


    private final GruppenRepository repo;

    public GruppenService(GruppenRepository repo) {
        this.repo = repo;
    }


    public List<?> getGruppen(){
        return repo.findAll();
    }

}