package com.example.helpstudent.Config;

import com.example.helpstudent.Repository.StudentRepository;
import com.example.helpstudent.Repository.StudiengangRepository;
import com.example.helpstudent.Tabellen.Student.Student;
import com.example.helpstudent.Tabellen.Student.Studiengang;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudiengangConfig {
    @Bean
    CommandLineRunner commandLineRunner2(StudiengangRepository repo){
        return args -> {

        };

    }
}
