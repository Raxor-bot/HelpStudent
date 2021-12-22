package com.example.helpstudent.Config;

import com.example.helpstudent.Repository.FachRepository;
import com.example.helpstudent.Repository.GruppenRepository;
import com.example.helpstudent.Repository.StudiengangRepository;
import com.example.helpstudent.Tabellen.Student.Fach;
import com.example.helpstudent.Tabellen.Student.Gruppe;
import com.example.helpstudent.Tabellen.Student.Studiengang;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FachConfig {
    @Bean
    CommandLineRunner commandLineRunner4(FachRepository repository, StudiengangRepository stRepository){
        return args -> {





            Studiengang ais = stRepository.getById(1L);

            List<Fach> fachliste = new ArrayList<Fach>();
            fachliste.add(new Fach("Arbeitstechniken u. Selbstmanagement",1));
            fachliste.add(new Fach("Schriftl. Kommunikation u. wissenschaftl.",1));
            fachliste.add(new Fach("Programmieren 1 VL",1));
            fachliste.add(new Fach("Webtechnologien VL",1));
            fachliste.add(new Fach("Webtechnologien ÜB ",1));
            fachliste.add(new Fach("Datenbanken VL",1));
            fachliste.add(new Fach("Grundlagen der Sozialen Medien VL",1));
            fachliste.add(new Fach("Mathematik 1 VL",1));
            fachliste.add(new Fach("Grundlagen der Sozialen Medien SE ",1));
            fachliste.add(new Fach("Mathematik 1 ÜB",1));
            fachliste.add(new Fach("Datenbanken ÜB",1));
            fachliste.add(new Fach("Programmieren 1 PR",1));
            fachliste.add(new Fach("Programmieren 1 VL",1));
            repository.saveAll(fachliste);


            ais.getFaecher().addAll(fachliste);

            stRepository.save(ais);














            repository.save(new Fach("Mathematik 3 VL",3));
            repository.save(new Fach("Mathematik 3 ÜB",3));
            repository.save(new Fach("Softwareprojekt 1 PR",3));
            repository.save(new Fach("Analyse in sozialen Netzwerken VL",3));
            repository.save(new Fach("Computersysteme VL",3));
            repository.save(new Fach("Analyse in sozialen Netzwerken ÜB ",3));
            repository.save(new Fach("Computersysteme ÜB",3));
            repository.save(new Fach("Softwaretechnik 1 VL",3));
            repository.save(new Fach("Softwaretechnik 1 ÜB",3));
            repository.save(new Fach("Mathematik 1 ÜB",3));
            repository.save(new Fach("Programmierkonzepte VL",3));
            repository.save(new Fach("Programmierkonzepte ÜB",3));
            repository.save(new Fach("Projektmanagement 1 SE",3));

            repository.save(new Fach("IT-Sicherheitsmanagement SE",7));
            repository.save(new Fach("Webapplikationssicherheit SE",7));
            repository.save(new Fach("Recommender Systems SE",7));
            repository.save(new Fach("Big Data and Cloud Computing SE",7));
            repository.save(new Fach("Informationsvisualisierung SE",7));
            repository.save(new Fach("Gestenbasierte Systeme SE",7));

            repository.save(new Fach("Unternehmensführung VL",1));
            repository.save(new Fach("Kundenmanagement",1));
            repository.save(new Fach("Unternehmensführung ÜB",1));
            repository.save(new Fach("Marktforschung VL/ÜB ",1));
            repository.save(new Fach("Sustainability Management VL/ÜB",1));
            repository.save(new Fach("Sustainability Management SE",1));
            repository.save(new Fach("Marketing SE",1));
            repository.save(new Fach("Unternehmensführung SE",1));

            repository.save(new Fach("Finance SE",3));
            repository.save(new Fach("Personalmanagement SE",3));
            repository.save(new Fach("Personalmanagement VL/ÜB",3));
            repository.save(new Fach("Externes Rechnungswesen SE",3));
            repository.save(new Fach("Finance VL/ÜB",3));
            repository.save(new Fach("Externes Rechnungswesen",3));

            repository.save(new Fach("Marketing VL",1));
            repository.save(new Fach("VWL VL/ÜB",1));
            repository.save(new Fach("Englisch VL/ÜB",1));
            repository.save(new Fach("Englisch VL/ÜB ",1));
            repository.save(new Fach("Rechnungswesen VL",1));
            repository.save(new Fach("Beschaffung und Produktion VL",1));
            repository.save(new Fach("Steuern VL ",1));

            repository.save(new Fach("Konsumentenverhalten VL",3));
            repository.save(new Fach("Konsumentenverhalten ÜB",3));
            repository.save(new Fach("Verhalten in Organisationen ÜB",3));
            repository.save(new Fach("Konsumentenverhalten SE",3));
            repository.save(new Fach("Verhalten in Organisationen SE",3));
            repository.save(new Fach("Arbeitstechniken u. Selbstmanagement SE",3));
            repository.save(new Fach("International Economics SE",3));
            repository.save(new Fach("Wirtschaftspolitik ÜB",3));
            repository.save(new Fach("Wirtschaftspolitik VL",3));
            repository.save(new Fach("Wirtschaftspolitik SE",3));
            repository.save(new Fach("Controlling SE",3));
            repository.save(new Fach("Strategisches Management SE ",3));
            repository.save(new Fach("Unternehmensbesteuerung SE",3));

        };
    }
}
