package com.example.helpstudent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/Login")
    public String viewlogin(){
        return "Login";
    }

    @RequestMapping("/Login/Register")
    public String viewRegister(){
        return "Register";
    }
}
