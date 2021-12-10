package com.example.helpstudent.Controller;


import com.example.helpstudent.Service.StudentService;
import com.example.helpstudent.Tabellen.Student.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class StudentController {

    private final StudentService service;

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

    @GetMapping("Profil/meineInfos/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id){
        Optional<Student> studentData = service.getStudent(id);

        return studentData.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping("/chat")
    public String viewChat(){
        return "chat";
    }
}
