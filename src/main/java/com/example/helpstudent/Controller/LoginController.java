package com.example.helpstudent.Controller;

import com.example.helpstudent.Service.*;
import com.example.helpstudent.Tabellen.Student.Student;
import com.example.helpstudent.registrierung.token.TokenError;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Controller
@AllArgsConstructor
@RequestMapping("/Login")
public class LoginController {
    private final RegistrationService registrierService;
    private final LoginService loginservice;
    private final StudentService studentService;
    TokenErrorService tokenerrservice;

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
        Boolean pwcheck = false;
        Map<String, Object> myMap = new HashMap<>();
        System.out.println(body.get("mail").toString());
        System.out.println(body.get("passwort").toString());
        myMap.put("url","http://localhost:8080/Login/perform_Login");
        try {
            pwcheck = loginservice.validate(body.get("mail").toString(), body.get("passwort").toString());
            {

            }} catch (Exception e){
            System.out.println(e.getMessage());
            myMap.put("errorMessage", "Bitte registriere dich zuerst!");
        }
        if (!pwcheck){
            System.out.println("Login wurde nicht validiert");
            myMap.put("errorMessage", "Bitte zuerst registrieren/Falsches PW");
            return new ResponseEntity<>(myMap, HttpStatus.OK);
        }
        else {
            myMap.clear();
            System.out.println("Er versucht auf Index zu kommen");
            myMap.put("url", "http://localhost:8080/home/");
            myMap.put("studentInformation", studentService.loadUserByUsername(body.get("mail").toString()));
            return new ResponseEntity<Object>(myMap, HttpStatus.OK);
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
            System.out.println(e.getMessage());
            myMap.put("errorMessage", e.getMessage());
        }
        return new ResponseEntity<Object>(myMap, HttpStatus.OK);    }

    @GetMapping(path = "/Register/bestaetigt")
    public String bestaetigen(@RequestParam String token) {
        System.out.println("Bestätige Token...");
        try {
            registrierService.bestaetigeToken(token);
            // bestaetService.saveTokenErrortxt(msg);
        } catch (Exception e){
            System.out.println(e.getMessage());
            tokenerrservice.saveTokenErrortxt(new TokenError(token,e.getMessage()));
        }
        return "Login";
    }

    @PostMapping("/Register/checktoken")
    public ResponseEntity<?> checkToken(@RequestParam String token){
        Map<String, Object> myMap = new HashMap<>();
        if(tokenerrservice.getTokenErrortxtbyToken(token) != null) {
            System.out.println(myMap);
            myMap.put("errorMessage", tokenerrservice.getTokenErrortxtbyToken(token));
        }
        System.out.println(myMap);
        return new ResponseEntity<Object>(myMap, HttpStatus.OK);

    }
}