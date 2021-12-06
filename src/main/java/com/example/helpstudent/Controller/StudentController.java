package com.example.helpstudent.Controller;


import com.example.helpstudent.Service.StudentService;
import com.example.helpstudent.Tabellen.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.ClientEndpoint;
import java.util.Map;
import java.util.Optional;

@Controller
public class StudentController{

    private final StudentService service ;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping("/home")
        public String viewLoginPage(ModelMap model) {
        model.addAttribute("listStudent", service.getStudents());
        return "index";
    }

    @GetMapping("/home/{mail}")
    public ResponseEntity<String> getUserData(@PathVariable String mail) {
        System.out.println("------------------TEST----------TEST-----------------------------");
        System.out.println(mail);
        System.out.println(service.loadUserByUsername(mail));
        return new ResponseEntity<>("http://localhost:8080/home?mail="+mail, HttpStatus.OK);
    }


    @RequestMapping("/chat")
    public String viewChat(){
        return "chat";
    }
    @RequestMapping("/Faecher")
    public String viewFaecher(){
        return "index";
    }
    @RequestMapping("/Gruppen")
    public String viewGruppen(){
        return "index";
    }
    @RequestMapping("/chatTest")
    public String viewTestChat(){
        return "chatTest";
    }
}
