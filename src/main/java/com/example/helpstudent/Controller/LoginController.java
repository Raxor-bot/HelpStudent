package com.example.helpstudent.Controller;

import com.example.helpstudent.Service.LoginService;
import com.example.helpstudent.Service.RegistrationService;
import com.example.helpstudent.Tabellen.Student.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
    public String perform_login(@RequestParam("mail")String mail,@RequestParam("password")String passwort) {
        System.out.println(mail);
        System.out.println(passwort);
        if (!loginservice.validate(mail,passwort)){
            System.out.println("Login wurde nicht validiert");
            return "redirect:/Login/?error=true";
        }else{
            System.out.println("Er versucht auf Index zu kommen");
            return "Index";
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
