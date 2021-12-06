package com.example.helpstudent.Controller;


import com.example.helpstudent.Service.StudentService;
import com.example.helpstudent.Tabellen.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping()
        public String viewHomePage(Model model) {
        model.addAttribute("listStudent", service.getStudents());
        return "index";
    }

    @RequestMapping("/Faecher")
    public String viewFaecher(){
        Student test = new Student("Test","Musterfest", LocalDate.now(),3,"test@stud.hshl.de","passwort","/src/Bild");
        service.addNewStudent(test);
        return "index";
    }
    @RequestMapping("/Gruppen")
    public String viewGruppen(){
        service.deleteStudent("test@stud.hshl.de");
        return "index";
    }
    @RequestMapping("/Register")
    public String viewRegister(){
        return "Register";
    }

    @RequestMapping("/Profil")
    public String viewProfil(){
        return "profil";
    }

}
