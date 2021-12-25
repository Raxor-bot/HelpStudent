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
            repo.save(new Studiengang("Angewandte Informatik und Soziale Medien"));
            repo.save(new Studiengang("Betriebswirtschaftslehre"));
            repo.save(new Studiengang("Biomedizinische Technologie"));
            repo.save(new Studiengang("Electronic Engineering"));
            repo.save(new Studiengang("Intelligent Systems Design"));
            repo.save(new Studiengang("Materialdesign - Bionik und Photonik"));
            repo.save(new Studiengang("Mechatronik"));
            repo.save(new Studiengang("Sport- und Gesundheitstechnik"));
            repo.save(new Studiengang("Technisches Management und Marketing"));
            repo.save(new Studiengang("Umweltmonitoring und Forensische Chemie"));
            repo.save(new Studiengang("Wirtschaftsingenieurwesen"));




            System.out.println("###################repositoryGang.getStudiengaenge(1L)#######################");
            System.out.println(repo.getStudiengaenge(1L));
            System.out.println("##########################################");
        };
    }
}
