package com.example.helpstudent.Controller;

import com.example.helpstudent.Service.GruppenService;
import com.example.helpstudent.Tabellen.Student.Gruppe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/Gruppe")
public class GruppenController {

    private final GruppenService gruppenService;

    public GruppenController(GruppenService gruppenService) {
        this.gruppenService = gruppenService;
    }


    @PostMapping("/getGruppen")
    public ResponseEntity<?> getGruppen() {
        Map<String, Object> myMap = new HashMap<>();
        System.out.println("Gruppennnnn--------------------------##################-----------------###############");
        System.out.println(gruppenService.getGruppen());
        myMap.put("gruppen",gruppenService.getGruppen());
        return new ResponseEntity<Object>(myMap, HttpStatus.OK);
    }

    @PostMapping("/creategroup")
    public ResponseEntity<?> erstelleGruppe(@RequestBody Map<String,Object> body){
        Map<String, Object> myMap = new HashMap<>();
        try {
            gruppenService.addNewGruppe(new Gruppe(
                    Integer.parseInt(body.get("gruppengroesse").toString()),
                    body.get("gruppenname").toString()
            ));
        }catch (Exception e){
            myMap.put("gruppentext",e.getMessage());
        }

        return new ResponseEntity<Object>(myMap, HttpStatus.OK);

    }
}
