package com.example.helpstudent.Controller;

import com.example.helpstudent.Tabellen.Student.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

    @GetMapping("/Login")
    public ModelAndView viewlogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Login");
        return modelAndView;
    }

    @RequestMapping("/Login/Register")
    public String viewRegister(Model model){
        model.addAttribute("Student",new Student());
        return "Register";
    }
}
