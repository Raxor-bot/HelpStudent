package com.example.helpstudent.Student;

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
            Student jannik = new Student("Jannik", "Markau", "jannik.markau@gmail.com", LocalDate.of(2000,Month.JULY,1));

            Student moritz = new Student(
                    "Moritz",
                    "Schüppel",
                    "Moritz.mail@gmail.com",
                    LocalDate.of(2000, Month.MAY, 3)
            );

            repository.saveAll(List.of(jannik,moritz));
        };
    }
}
