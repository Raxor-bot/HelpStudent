package com.example.helpstudent.Controller;

import com.example.helpstudent.Service.FachService;
import com.example.helpstudent.Service.StudiengangService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class StudiengangController {

    private final StudiengangService studiengangService;
    public final FachService fachService;

    public StudiengangController(StudiengangService studiengangService, FachService fachService) {
        this.studiengangService = studiengangService;
        this.fachService = fachService;
    }

    @GetMapping("/studiengaenge")
    public ResponseEntity<?> getStudiengaenge(){
        Map<String, Object> myMap = new HashMap<>();
        System.out.println("Studiengang--------------------------##################-----------------###############");
        System.out.println(studiengangService.getAllStudiengaenge());
        myMap.put("Studiengang",studiengangService.getAllStudiengaenge());
        return new ResponseEntity<Object>(myMap, HttpStatus.OK);
    }

    @GetMapping("/faecher")
    public ResponseEntity<?> getFaecher(){
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("Fach",fachService.getAllFaecher());
        System.out.println("Fächer gesendet");
        System.out.println(fachService.getAllFaecher());
        return new ResponseEntity<Object>(myMap, HttpStatus.OK);
    }
}