package com.example.helpstudent.Controller;

import com.example.helpstudent.Service.StudiengangService;
import com.example.helpstudent.Tabellen.Student.Student;
import com.example.helpstudent.Tabellen.Student.Studiengang;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class StudiengangController {

    private final StudiengangService studiengangService;

    public StudiengangController(StudiengangService studiengangService) {
        this.studiengangService = studiengangService;
    }

    @GetMapping("/studiengaenge")
    public ResponseEntity<?> getStudiengaenge(){
        Map<String, Object> myMap = new HashMap<>();
        System.out.println("Studiengang--------------------------##################-----------------###############");
        System.out.println(studiengangService.getAllStudiengaenge());
        myMap.put("Studiengang",studiengangService.getAllStudiengaenge());
        return new ResponseEntity<Object>(myMap, HttpStatus.OK);
    }
}