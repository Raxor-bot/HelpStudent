package com.example.helpstudent.Config;

import com.example.helpstudent.Repository.StudentRepository;
import com.example.helpstudent.Tabellen.Student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

            Student armin = new Student(
                    "Reimann",
                    "Armin",
                    "reimann.armin2@gmail.com",
                    "passwort123"
            );

          repository.save(jannik);
          repository.enableStudent("Jannik.markau01@gmail.com");
          repository.save(armin);
          repository.enableStudent("reimann.armin2@gmail.com");
        };

    }
}
