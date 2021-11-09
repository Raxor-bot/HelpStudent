package com.example.helpstudent.registrierung;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/Login")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrierService;

    @PostMapping
    public String registrieren(@RequestBody RegAnfrage anfrage){
        System.out.println("regi");
        return registrierService.registrieren(anfrage);
    }

    @GetMapping(path = "bestaetigt")
    public String bestaetigen(@RequestParam("token")String token) {
        return registrierService.bestaetigeToken(token);
    }
}
