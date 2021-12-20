package com.example.helpstudent.Service;

import com.example.helpstudent.Repository.GruppenRepository;
import com.example.helpstudent.Tabellen.Student.Student;
import com.example.helpstudent.Repository.StudentRepository;
import com.example.helpstudent.registrierung.token.BestaetigungsToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class GruppenService{

    @Autowired
    private final GruppenRepository repo;


    @Autowired
    public GruppenService(GruppenRepository repo) {
        this.repo = repo;
    }


    public List<?> getGruppen(){
        return repo.findAll();
    }

}