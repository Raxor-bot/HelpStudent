package com.example.helpstudent.Controller;

import com.example.helpstudent.Tabellen.Student.Student;
import com.example.helpstudent.Service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/Login/Register")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrierService;

    @PostMapping()
    public String registrieren(@ModelAttribute("Student") Student student){
        System.out.println(student.toString());
        return registrierService.registrierenValidierung(student);
    }

    @GetMapping(path = "Login/Register/bestaetigt")
    public String bestaetigen(@RequestParam("token")String token) {
        registrierService.bestaetigeToken(token);
        return "Login";
    }
}
