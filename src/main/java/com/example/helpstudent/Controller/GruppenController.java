package com.example.helpstudent.Controller;

import com.example.helpstudent.Service.FachService;
import com.example.helpstudent.Service.GruppenService;
import com.example.helpstudent.Service.StudentService;
import com.example.helpstudent.Tabellen.Gruppe;
import com.example.helpstudent.Tabellen.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequestMapping("/Gruppen")
@Controller
public class GruppenController {

    private final GruppenService gruppenService;
    private final FachService fachService;
    private final StudentService studentService;

    public GruppenController(GruppenService gruppenService,FachService fachService, StudentService studentService) {
        this.gruppenService = gruppenService;
        this.fachService = fachService;
        this.studentService = studentService;
    }


    @PostMapping("/getGruppen")
    public ResponseEntity<?> getGruppen() {
        Map<String, Object> myMap = new HashMap<>();
        System.out.println("Gruppennnnn--------------------------##################-----------------###############");
        System.out.println(gruppenService.getGruppen());
        System.out.println("##########################################################################################");
        myMap.put("gruppen",gruppenService.getGruppen());
        return new ResponseEntity<Object>(myMap, HttpStatus.OK);
    }

    @PostMapping("/erstelleGruppe")
    public ResponseEntity<?> erstelleGruppe(@RequestBody Map<String,Object> body){
        Logger logger = LoggerFactory.getLogger(GruppenController.class);

        Map<String, Object> myMap = new HashMap<>();
        Student student = studentService.getStudentByID(Long.parseLong(body.get("studentenid").toString())).orElseThrow(NoSuchElementException::new);
        Gruppe gruppe = new Gruppe(body.get("gruppenname").toString(),fachService.getFachById(Long.parseLong(body.get("fachid").toString())),student);

        logger.info(student.toString());
        logger.info(gruppe.toString());

            try {
                gruppenService.addNewGruppe(gruppe);

                myMap.put("gruppentext", "wurde erstellt");
            } catch (NoSuchElementException e) {
                myMap.put("gruppentext", "Nutzer existiert nicht");
            } catch (Exception e) {
                myMap.put("ereortext", "Gruppe konnte nicht erstellt werden!");
            }

        return new ResponseEntity<Object>(myMap, HttpStatus.OK);
    }
    @PostMapping("/gruppe_beitreten")
    public ResponseEntity<?> gruppeBeitreten(@RequestBody Map<String,Object> body) {
        Map<String, Object> myMap = new HashMap<>();
        Student student = studentService.getStudentByID(Long.parseLong(body.get("studentenid").toString())).orElseThrow(NoSuchElementException::new);
        Gruppe gruppe = gruppenService.getGruppebyId(Long.parseLong(body.get("gruppenid").toString())).orElseThrow(NoSuchElementException::new);
            studentService.addStudentGruppe(student,gruppe);
    return new ResponseEntity<Object>(myMap, HttpStatus.OK);
    }
    @PostMapping("/gruppe_verlassen")
    public ResponseEntity<?> gruppeVerlassen(@RequestBody Map<String,Object> body) {
        Map<String, Object> myMap = new HashMap<>();
        Student student = studentService.getStudentByID(Long.parseLong(body.get("studentenid").toString())).orElseThrow(NoSuchElementException::new);
        Gruppe gruppe = gruppenService.getGruppebyId(Long.parseLong(body.get("gruppenid").toString())).orElseThrow(NoSuchElementException::new);
            studentService.removeStudentGruppe(student,gruppe);
    return new ResponseEntity<Object>(myMap, HttpStatus.OK);
    }
}
