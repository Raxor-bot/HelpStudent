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
import org.springframework.transaction.annotation.Transactional;

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


            stRepository.save(new Studiengang("Ais",fachliste));




            fachliste.add(new Fach("Mathematik 3 VL",3));
            fachliste.add(new Fach("Mathematik 3 ÜB",3));
            fachliste.add(new Fach("Softwareprojekt 1 PR",3));
            fachliste.add(new Fach("Analyse in sozialen Netzwerken VL",3));
            fachliste.add(new Fach("Computersysteme VL",3));
            fachliste.add(new Fach("Analyse in sozialen Netzwerken ÜB ",3));
            fachliste.add(new Fach("Computersysteme ÜB",3));
            fachliste.add(new Fach("Softwaretechnik 1 VL",3));
            fachliste.add(new Fach("Softwaretechnik 1 ÜB",3));
            fachliste.add(new Fach("Mathematik 1 ÜB",3));
            fachliste.add(new Fach("Programmierkonzepte VL",3));
            fachliste.add(new Fach("Programmierkonzepte ÜB",3));
            fachliste.add(new Fach("Projektmanagement 1 SE",3));

            fachliste.add(new Fach("IT-Sicherheitsmanagement SE",7));
            fachliste.add(new Fach("Webapplikationssicherheit SE",7));
            fachliste.add(new Fach("Recommender Systems SE",7));
            fachliste.add(new Fach("Big Data and Cloud Computing SE",7));
            fachliste.add(new Fach("Informationsvisualisierung SE",7));
            fachliste.add(new Fach("Gestenbasierte Systeme SE",7));

            fachliste.add(new Fach("Unternehmensführung VL",1));
            fachliste.add(new Fach("Kundenmanagement",1));
            fachliste.add(new Fach("Unternehmensführung ÜB",1));
            fachliste.add(new Fach("Marktforschung VL/ÜB ",1));
            fachliste.add(new Fach("Sustainability Management VL/ÜB",1));
            fachliste.add(new Fach("Sustainability Management SE",1));
            fachliste.add(new Fach("Marketing SE",1));
            fachliste.add(new Fach("Unternehmensführung SE",1));

            fachliste.add(new Fach("Finance SE",3));
            fachliste.add(new Fach("Personalmanagement SE",3));
            fachliste.add(new Fach("Personalmanagement VL/ÜB",3));
            fachliste.add(new Fach("Externes Rechnungswesen SE",3));
            fachliste.add(new Fach("Finance VL/ÜB",3));
            fachliste.add(new Fach("Externes Rechnungswesen",3));

            fachliste.add(new Fach("Marketing VL",1));
            fachliste.add(new Fach("VWL VL/ÜB",1));
            fachliste.add(new Fach("Englisch VL/ÜB",1));
            fachliste.add(new Fach("Englisch VL/ÜB ",1));
            fachliste.add(new Fach("Rechnungswesen VL",1));
            fachliste.add(new Fach("Beschaffung und Produktion VL",1));
            fachliste.add(new Fach("Steuern VL ",1));

            fachliste.add(new Fach("Konsumentenverhalten VL",3));
            fachliste.add(new Fach("Konsumentenverhalten ÜB",3));
            fachliste.add(new Fach("Verhalten in Organisationen ÜB",3));
            fachliste.add(new Fach("Konsumentenverhalten SE",3));
            fachliste.add(new Fach("Verhalten in Organisationen SE",3));
            fachliste.add(new Fach("Arbeitstechniken u. Selbstmanagement SE",3));
            fachliste.add(new Fach("International Economics SE",3));
            fachliste.add(new Fach("Wirtschaftspolitik ÜB",3));
            fachliste.add(new Fach("Wirtschaftspolitik VL",3));
            fachliste.add(new Fach("Wirtschaftspolitik SE",3));
            fachliste.add(new Fach("Controlling SE",3));
            fachliste.add(new Fach("Strategisches Management SE ",3));
            fachliste.add(new Fach("Unternehmensbesteuerung SE",3));

            repository.saveAll(fachliste);

        };
    }
}
