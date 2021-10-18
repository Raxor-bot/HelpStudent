package com.example.helpstudent.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
        public String viewHomePage(Model model) {
        List<Student> listStudent = service.listAll();
        model.addAttribute("listStudent", listStudent);
        return "index";
    }
}
