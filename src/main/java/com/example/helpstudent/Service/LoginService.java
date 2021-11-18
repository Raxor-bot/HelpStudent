package com.example.helpstudent.Service;

import com.example.helpstudent.Repository.StudentRepository;
import com.example.helpstudent.security.PasswortEncoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class LoginService {
    private final StudentRepository repo;
    private final PasswortEncoder pwencoder;

    public Boolean validate(String username,String password){
         return pwencoder.bCryptPasswordEncoder().matches( password, repo.findStudentByMail(username).get().getPassword());
    }
}
