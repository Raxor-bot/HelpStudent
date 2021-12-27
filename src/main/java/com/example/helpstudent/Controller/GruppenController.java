package com.example.helpstudent.Controller;

import com.example.helpstudent.Service.GruppenService;
import com.example.helpstudent.Service.StudiengangService;
import com.example.helpstudent.Tabellen.Student.Gruppe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/Gruppen")
public class GruppenController {

    private final GruppenService gruppenService;
    private final StudiengangService studService;

    public GruppenController(GruppenService gruppenService, StudiengangService studService) {
        this.gruppenService = gruppenService;
        this.studService = studService;
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
        System.out.println("---------------------------------GETTIT---------------------");
       // try {
            gruppenService.addNewGruppe(new Gruppe(
                    Integer.parseInt(body.get("gruppengroesse").toString()),
                    body.get("gruppenname").toString(),
                    studService.getStudiengangbyName(body.get("stdgangid")
                            .toString()).getStudiengangid(),
                    Long.getLong(body.get("studentenid").toString())
            ));
     //   }catch (Exception e){
     //       myMap.put("gruppentext",e.getMessage());
     //   }

        return new ResponseEntity<Object>(myMap, HttpStatus.OK);

    }

    @PostMapping("/test")
    public ResponseEntity<?> Test(@RequestBody Map<String,Object> body){
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("gruppentext","Schön wäres");
        System.out.println("Zumindest das");
        return new ResponseEntity<Object>(myMap, HttpStatus.OK);
    }
}
