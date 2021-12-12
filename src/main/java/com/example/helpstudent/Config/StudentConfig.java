package com.example.helpstudent.Config;

import com.example.helpstudent.Repository.StudentRepository;
import com.example.helpstudent.Tabellen.Student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;


@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
          Student jannik = new Student(
                  "Markau",
                  "Jannik",
                  "Jannik.markau01@gmail.com",
                  "996460"
                  );

          repository.save(jannik);
        };

    }
}
