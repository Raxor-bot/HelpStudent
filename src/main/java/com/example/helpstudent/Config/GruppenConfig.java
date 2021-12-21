package com.example.helpstudent.Config;

import com.example.helpstudent.Repository.GruppenRepository;
import com.example.helpstudent.Tabellen.Student.Gruppe;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GruppenConfig {
    @Bean
    CommandLineRunner commandLineRunner(GruppenRepository repository){
        return args -> {
//            Gruppe gruppe
//
//
//
//
//
//
//
//
//            repository.save(gruppe);
        };
    }
}
