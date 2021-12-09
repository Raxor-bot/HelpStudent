package com.example.helpstudent.Config;

import com.example.helpstudent.Tabellen.Student.Student;
import com.example.helpstudent.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
          Student jannik = new Student(
                  "Markau",
                  "Jannik",
                  LocalDate.now(),
                  3,
                  "Jannik.markau01@gmail.com",
                  "996460",
                  "/...");

          repository.save(jannik);
        };

    }
}
