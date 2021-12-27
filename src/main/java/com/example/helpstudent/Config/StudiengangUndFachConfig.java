package com.example.helpstudent.Config;


import com.example.helpstudent.Service.FachService;
import com.example.helpstudent.Service.StudiengangService;
import com.example.helpstudent.Tabellen.Student.Fach;
import com.example.helpstudent.Tabellen.Student.Studiengang;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
@Order(2)
public class StudiengangUndFachConfig implements CommandLineRunner{

    private Logger logger = LoggerFactory.getLogger(StudiengangUndFachConfig.class);
    private List<Fach> fachListe;
    private final StudiengangService studiengangService;
    private final FachService fachService;

    public StudiengangUndFachConfig(List<Fach> fachListe, StudiengangService studiengangService, FachService fachService) {
        this.fachListe = fachListe;
        this.studiengangService = studiengangService;
        this.fachService = fachService;
    }

    @Override
    public void run(String... args){
        logger.info("Studiengänge werden erstellt");

        logger.info("AIS 1");
        fachListe.add(new Fach("Arbeitstechniken u. Selbstmanagement",1));
        fachListe.add(new Fach("Schriftl. Kommunikation u. wissenschaftl.",1));
        fachListe.add(new Fach("Programmieren 1 VL",1));
        fachListe.add(new Fach("Webtechnologien VL",1));
        fachListe.add(new Fach("Webtechnologien ÜB ",1));
        fachListe.add(new Fach("Datenbanken VL",1));
        fachListe.add(new Fach("Grundlagen der Sozialen Medien VL",1));
        fachListe.add(new Fach("Mathematik 1 VL",1));
        fachListe.add(new Fach("Grundlagen der Sozialen Medien SE ",1));
        fachListe.add(new Fach("Mathematik 1 ÜB",1));
        fachListe.add(new Fach("Datenbanken ÜB",1));
        fachListe.add(new Fach("Programmieren 1 PR",1));
        fachListe.add(new Fach("Programmieren 1 VL",1));

        fachService.saveAll(fachListe);
        studiengangService.save(new Studiengang(
                "Angewandte Informatik und Soziale Medien",
                "AIS 1",
                fachListe));
        fachListe.clear();

        logger.info("AIS 3");
        fachListe.add(new Fach("Mathematik 3 VL",3));
        fachListe.add(new Fach("Mathematik 3 ÜB",3));
        fachListe.add(new Fach("Softwareprojekt 1 PR",3));
        fachListe.add(new Fach("Analyse in sozialen Netzwerken VL",3));
        fachListe.add(new Fach("Computersysteme VL",3));
        fachListe.add(new Fach("Analyse in sozialen Netzwerken ÜB ",3));
        fachListe.add(new Fach("Computersysteme ÜB",3));
        fachListe.add(new Fach("Softwaretechnik 1 VL",3));
        fachListe.add(new Fach("Softwaretechnik 1 ÜB",3));
        fachListe.add(new Fach("Programmierkonzepte VL",3));
        fachListe.add(new Fach("Programmierkonzepte ÜB",3));
        fachListe.add(new Fach("Projektmanagement 1 SE",3));

        fachService.saveAll(fachListe);
        studiengangService.save(new Studiengang(
                "Angewandte Informatik und Soziale Medien 3",
                "AIS 3",
                fachListe));
        fachListe.clear();

        logger.info("AIS 7");
        fachListe.add(new Fach("IT-Sicherheitsmanagement SE",7));
        fachListe.add(new Fach("Webapplikationssicherheit SE",7));
        fachListe.add(new Fach("Recommender Systems SE",7));
        fachListe.add(new Fach("Big Data and Cloud Computing SE",7));
        fachListe.add(new Fach("Informationsvisualisierung SE",7));
        fachListe.add(new Fach("Gestenbasierte Systeme SE",7));

        fachService.saveAll(fachListe);
        studiengangService.save(new Studiengang(
                "Angewandte Informatik und Soziale Medien 7",
                "AIS 7",
                fachListe));
        fachListe.clear();

        logger.info("BWM 1");
        fachListe.add(new Fach("Unternehmensführung VL",1));
        fachListe.add(new Fach("Kundenmanagement",1));
        fachListe.add(new Fach("Unternehmensführung ÜB",1));
        fachListe.add(new Fach("Marktforschung VL/ÜB ",1));
        fachListe.add(new Fach("Sustainability Management VL/ÜB",1));
        fachListe.add(new Fach("Sustainability Management SE",1));
        fachListe.add(new Fach("Marketing SE",1));
        fachListe.add(new Fach("Unternehmensführung SE",1));

        fachService.saveAll(fachListe);
        studiengangService.save(new Studiengang(
                "Betriebswirtschaftslehre 1 (Master)",
                "BWM 1",
                fachListe));
        fachListe.clear();

        logger.info("BWM 3");
        fachListe.add(new Fach("Finance SE",3));
        fachListe.add(new Fach("Personalmanagement SE",3));
        fachListe.add(new Fach("Personalmanagement VL/ÜB",3));
        fachListe.add(new Fach("Externes Rechnungswesen SE",3));
        fachListe.add(new Fach("Finance VL/ÜB",3));
        fachListe.add(new Fach("Externes Rechnungswesen",3));

        fachService.saveAll(fachListe);
        studiengangService.save(new Studiengang(
                "Betriebswirtschaftslehre 3 (Master)",
                "BWM 3",
                fachListe));
        fachListe.clear();

        logger.info("BWL 1");
        fachListe.add(new Fach("Marketing VL",1));
        fachListe.add(new Fach("VWL VL/ÜB",1));
        fachListe.add(new Fach("Englisch VL/ÜB",1));
        fachListe.add(new Fach("Rechnungswesen VL",1));
        fachListe.add(new Fach("Beschaffung und Produktion VL",1));
        fachListe.add(new Fach("Steuern VL ",1));

        fachService.saveAll(fachListe);

        fachListe.add(fachService.getFachByName("Mathematik 1 VL"));
        fachListe.add(fachService.getFachByName("Mathematik 1 ÜB"));

        studiengangService.save(new Studiengang(
                "Betriebswirtschaftslehre 1",
                "BWL 1",
                fachListe));
        fachListe.clear();

        logger.info("BWL 3");
        fachListe.add(new Fach("Konsumentenverhalten VL",3));
        fachListe.add(new Fach("Konsumentenverhalten ÜB",3));
        fachListe.add(new Fach("Verhalten in Organisationen ÜB",3));
        fachListe.add(new Fach("Konsumentenverhalten SE",3));
        fachListe.add(new Fach("Verhalten in Organisationen SE",3));
        fachListe.add(new Fach("Arbeitstechniken u. Selbstmanagement SE",3));
        fachListe.add(new Fach("International Economics SE",3));
        fachListe.add(new Fach("Wirtschaftspolitik ÜB",3));
        fachListe.add(new Fach("Wirtschaftspolitik VL",3));
        fachListe.add(new Fach("Wirtschaftspolitik SE",3));
        fachListe.add(new Fach("Controlling SE",3));
        fachListe.add(new Fach("Strategisches Management SE ",3));
        fachListe.add(new Fach("Unternehmensbesteuerung SE",3));
        fachListe.add(new Fach("Mündliche Kommunikation u. Präsentation SE",3));

        fachService.saveAll(fachListe);
        studiengangService.save(new Studiengang(
                "Betriebswirtschaftslehre 3",
                "BWL 3", fachListe));
        fachListe.clear();

        logger.info("BWL 5");
        fachListe.add(new Fach("Asian Economics VL/ÜB",3));
        fachListe.add(new Fach("Multinational Enterprises (MNEs) / International Economics",3));
        fachListe.add(new Fach("Marktforschung ÜB",3));
        fachListe.add(new Fach("Investition VL",3));
        fachListe.add(new Fach("Internationale Rechnungslegung VL",3));
        fachListe.add(new Fach("International Human Resource Management",3));
        fachListe.add(new Fach("Marktforschung VL",3));
        fachListe.add(new Fach("Organisation in Familien- u. Mittelstandsunternehmen",3));
        fachListe.add(new Fach("Personalmanagement Arbeitsbeziehungen ÜB",3));
        fachListe.add(new Fach("Mathematik 2 Wiederholerübung",3));
        fachListe.add(new Fach("International Economics",3));
        fachListe.add(new Fach("Regionalökonomie u. Wirtschaftsförderung VL",3));
        fachListe.add(new Fach("Projektmanagement und Teamarbeit SE",3));
        fachListe.add(new Fach("Design: Projekt (Digital) ÜB",3));
        fachListe.add(new Fach("Softwareanwendung: InDesign/Illustrator ÜB",3));
        fachListe.add(new Fach("Marketing: Corporate Identity VL",3));
        fachListe.add(new Fach("Internationale Rechnungslegung SE",3));
        fachListe.add(new Fach("Personalmanagement & Arbeitsbeziehungen VL ",3));
        fachListe.add(new Fach("Personalmanagement Arbeitsbeziehungen SE",3));
        fachListe.add(new Fach("Interkulturelles Management VL",3));

        fachService.saveAll(fachListe);
        studiengangService.save(new Studiengang(
                "Betriebswirtschaftslehre 5",
                "BWL 5", fachListe));
        fachListe.clear();

        logger.info("BSE 1");
        fachListe.add(new Fach("Regelungstechnische Systeme VL",1));
        fachListe.add(new Fach("Regelungstechnische Systeme ÜB",1));
        fachListe.add(new Fach("Systemtheorie SE",1));
        fachListe.add(new Fach("Produktgestaltung- und entwicklung VL",1));
        fachListe.add(new Fach("Produktgestaltung- und entwicklung ÜB",1));
        fachListe.add(new Fach("Führungsfähigkeiten SE ",1));
        fachListe.add(new Fach("Industrial Engineering & innovative Fertigungstechnologien",1));
        fachListe.add(new Fach("Industrial Engineering & innovative Fertigungstechnologien VL",1));
        fachListe.add(new Fach("Angewandte Elektrotechnik PR",1));
        fachListe.add(new Fach("Moderne Tracking Systeme ÜB",1));
        fachListe.add(new Fach("Angewandte Physik SE ",1));
        fachListe.add(new Fach("Moderne Tracking Systeme VL",1));
        fachListe.add(new Fach("Sicherheitsmanagement VL",1));

        fachService.saveAll(fachListe);
        studiengangService.save(new Studiengang(
                "Buisness and System Engeenring",
                "BSE 1", fachListe));
        fachListe.clear();

        logger.info("CVD 1");
        fachListe.add(new Fach("Einführung in die Informatik ÜB",1));
        fachListe.add(new Fach("Gestaltungs- u. Entwurfsgrundlagen 1 VL",1));
        fachListe.add(new Fach("Gestaltungs- u. Entwurfsgrundlagen 1 ÜB",1));
        fachListe.add(new Fach("Produktgestaltung- und entwicklung ÜB",1));
        fachListe.add(new Fach("Arbeitstechniken & Selbstmanagement SEL",1));
        fachListe.add(new Fach("Schriftliche Kommunikation u. wissenschaftl. Arbeiten ",1));
        fachListe.add(new Fach("Einführung in die Informatik PR",1));
        fachListe.add(new Fach("Grundlagen Humanwissenschaften VL",1));
        fachListe.add(new Fach("Gestaltungs- u. Entwurfsgrundlagen Zeichnen ",1));
        fachListe.add(new Fach("3D Grundlagen ÜB",1));
        fachListe.add(new Fach("Moderne Tracking Systeme VL",1));
        fachListe.add(new Fach("Einführung in die Informatik VL",1));

        fachService.saveAll(fachListe);
        studiengangService.save(new Studiengang(
                "Computervisualistik und Design",
                "CVD 1", fachListe));
        fachListe.clear();
























        logger.info("Studiengänge wurden erstellt");
    }
}
