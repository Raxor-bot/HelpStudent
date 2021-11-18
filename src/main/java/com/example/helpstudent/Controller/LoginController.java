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

    @GetMapping("/perform_login")
    public String perform_login(@RequestParam("username")String mail,@RequestParam("password")String passwort) {
        if (!loginservice.validate(mail,passwort)){
            return "redirect:/Login/?error=true";
        }
        else
        return "Index";
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
