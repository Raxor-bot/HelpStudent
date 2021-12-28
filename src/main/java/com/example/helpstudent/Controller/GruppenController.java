package com.example.helpstudent.Controller;

import com.example.helpstudent.Service.GruppenService;
import com.example.helpstudent.Service.StudentService;
import com.example.helpstudent.Service.StudiengangService;
import com.example.helpstudent.Tabellen.Student.Gruppe;
import com.example.helpstudent.Tabellen.Student.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RequestMapping("/Gruppen")
@Controller
public class GruppenController {

    private final GruppenService gruppenService;
    private final StudiengangService studiengangService;
    private final StudentService  studentService;

    public GruppenController(GruppenService gruppenService, StudiengangService studService, StudentService studentService) {
        this.gruppenService = gruppenService;
        this.studiengangService = studService;
        this.studentService = studentService;
    }


    @PostMapping("/getGruppen")
    public ResponseEntity<?> getGruppen() {
        Map<String, Object> myMap = new HashMap<>();
        System.out.println("Gruppennnnn--------------------------##################-----------------###############");
        System.out.println(gruppenService.getGruppen());
        myMap.put("gruppen",gruppenService.getGruppen());
        return new ResponseEntity<Object>(myMap, HttpStatus.OK);
    }

    @PostMapping("/erstelleGruppe")
    public ResponseEntity<?> erstelleGruppe(@RequestBody Map<String,Object> body){
        Map<String, Object> myMap = new HashMap<>();
        try {
        Student student = studentService.getStudentByID(Long.parseLong(body.get("studentenid").toString())).orElseThrow(NoSuchElementException::new);

        gruppenService.addNewGruppe(new Gruppe(
                    Integer.parseInt(body.get("gruppengroesse").toString()),
                    body.get("gruppenname").toString(),
                    studiengangService.getStudiengangbyName(body.get("stdgangname").toString()),
                    student

            ));
        System.out.println( studiengangService.getStudiengangbyName(body.get("stdgangname").toString()).getStName());
        }catch (NoSuchElementException e){
            myMap.put("gruppentext","Nutzer existiert nicht");
        } catch (Exception e){
            myMap.put("ereortext","Gruppe konnte nicht erstellt werden!");
        }

        return new ResponseEntity<Object>(myMap, HttpStatus.OK);

    }
}
