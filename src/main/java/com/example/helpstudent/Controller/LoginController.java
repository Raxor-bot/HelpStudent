package com.example.helpstudent.Controller;

import com.example.helpstudent.Service.LoginService;
import com.example.helpstudent.Service.RegistrationService;
import com.example.helpstudent.Tabellen.Student.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@AllArgsConstructor
@RequestMapping("/Login")
public class LoginController {
    private final RegistrationService registrierService;
    private final LoginService loginservice;

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
    public ResponseEntity<String> perform_login(@RequestBody Map<String,Object> body) {
        System.out.println(body.get("mail").toString());
        System.out.println(body.get("passwort").toString());
        if (!loginservice.validate(body.get("mail").toString(),body.get("passwort").toString())){
            System.out.println("Login wurde nicht validiert");
            return new ResponseEntity<>("LoginRedirect", HttpStatus.OK);
        }else{
            System.out.println("Er versucht auf Index zu kommen");
            return new ResponseEntity<>("IchWillIndex", HttpStatus.OK);
        }
    }

    @PostMapping(path = "/Register/new_user")
    public String registrieren(@RequestBody() Student student){
        System.out.println(student.toString());
        registrierService.registrierenValidierung(student);
        return "redirect:/Login";
    }

    @GetMapping(path = "/Register/bestaetigt")
    public String bestaetigen(@RequestParam("token")String token) {
        System.out.println("BESTÄTIGE");
        registrierService.bestaetigeToken(token);
        return "redirect:/Login";
    }
}
