package com.example.helpstudent.Controller;

import com.example.helpstudent.Service.LoginService;
import com.example.helpstudent.Service.RegistrationService;
import com.example.helpstudent.Service.StudentService;
import com.example.helpstudent.Tabellen.Student.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
@AllArgsConstructor
@RequestMapping("/Login")
public class LoginController {
    private final RegistrationService registrierService;
    private final LoginService loginservice;
    private final StudentService studentService;

    @GetMapping()
    public String viewlogin(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
       String errorMessge = null;
        if(error != null) {
            errorMessge = "E-Mail oder Passwort ist falsch!";
        }
        if(logout != null) {
            errorMessge = "Du wurdest erfolgreich asugeloggt!";
        }
        model.addAttribute("errorMessge", errorMessge);
        return "Login.html";
    }


    @RequestMapping("/Register")
    public String viewRegister(){
        return "Register.html";
    }

    @PostMapping("/perform_login")
    public ResponseEntity<?> perform_login(@RequestBody Map<String,Object> body) {
        //kommentar
        Map<String, Object> myMap = new HashMap<>();
        System.out.println(body.get("mail").toString());
        System.out.println(body.get("passwort").toString());
        if (!loginservice.validate(body.get("mail").toString(),body.get("passwort").toString())){
            System.out.println("Login wurde nicht validiert");
            return new ResponseEntity<>("LoginRedirect", HttpStatus.OK);
        }else{
            System.out.println("Er versucht auf Index zu kommen");
            myMap.put("url", "http://localhost:8080/home/");
            myMap.put("studentInformation", studentService.loadUserByUsername(body.get("mail").toString()));
            return new ResponseEntity<Object>(myMap,HttpStatus.OK);
//            return new ResponseEntity<>("http://localhost:8080/home/", HttpStatus.OK);
        }
    }

    @PostMapping(path = "/Register/new_user")
    public ResponseEntity<?> registrieren(@RequestBody() Student student){
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("url","http://localhost:8080/Login/");
        System.out.println(student.toString());
//        registrierService.registrierenValidierung(student);
        try {
            registrierService.registrierenValidierung(student);
        } catch (Exception e){
            System.out.println("im catch");
            myMap.put("errorMessage", e);
        }
        return new ResponseEntity<Object>(myMap, HttpStatus.OK);    }

    @GetMapping(path = "/Register/bestaetigt")
    public String bestaetigen(@RequestParam String token) {
        String message = null;
        System.out.println("BESTÄTIGE");
        message = registrierService.bestaetigeToken(token);
//        return new ResponseEntity<>("http://localhost:8080/Login/", HttpStatus.OK);
        return "Login";
    }
}
