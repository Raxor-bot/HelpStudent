package com.example.helpstudent.Service;

import com.example.helpstudent.Repository.StudentRepository;
import com.example.helpstudent.security.PasswortEncoder;

import org.springframework.stereotype.Service;


@Service
public class LoginService {
	
	private final StudentRepository repo;
    private final PasswortEncoder pwencoder;

    public LoginService(StudentRepository stud, PasswortEncoder pwencoder){
        this.repo = stud;
        this.pwencoder = pwencoder;
    }
    
    

    public Boolean validate(String username,String password){
         return pwencoder.bCryptPasswordEncoder().matches( password, repo.findStudentByMail(username).get().getPassword());
    }
}
