package com.example.helpstudent.Controller;


import com.example.helpstudent.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping("/")
        public String viewLoginPage(ModelMap model) {
        model.addAttribute("listStudent", service.getStudents());
        return "login";
    }

    @RequestMapping("/Index")
    public String viewHomePage(ModelMap model) {
        model.addAttribute("listStudent", service.getStudents());
        return "Index.html";
    }

    @RequestMapping("/Faecher")
    public String viewFaecher(){
        return "index";
    }
    @RequestMapping("/Gruppen")
    public String viewGruppen(){
        return "index";
    }
}
