package com.example.helpstudent.Service;

import com.example.helpstudent.Repository.StudiengangRepository;
import com.example.helpstudent.Tabellen.Studiengang;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudiengangService {

    private final StudiengangRepository studentrep;

    public StudiengangService(StudiengangRepository studentrep) {
        this.studentrep = studentrep;
    }

    public List<Studiengang> getAllStudiengaenge(){
        return studentrep.findAll();
    }

    public Studiengang getStudiengangById(Long id){
        System.out.println(studentrep.getStudiengangsByStudiengangid(id));
        return  studentrep.getStudiengangsByStudiengangid(id);
    }

    public void save(Studiengang studiengang) {
        studentrep.save(studiengang);
    }

    public Studiengang getStudiengangbyName(String stName){
        return studentrep.getStudiengangByStName(stName);
    }
}
