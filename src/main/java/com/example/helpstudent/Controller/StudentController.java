package com.example.helpstudent.Controller;


import com.example.helpstudent.Service.StudentService;
import com.example.helpstudent.Tabellen.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    @RequestMapping("/Faecher")
    public String viewFaecher(){
        return "Index";
    }
    @RequestMapping("/Gruppen")
    public String viewGruppen(){
        return "Gruppen";
    }
    @RequestMapping("/Register")
    public String viewRegister(){
        return "Register";
    }

    @RequestMapping("/Profil")
    public String viewProfil(){
        return "Profil";
    }

    @GetMapping("Profil/meineInfos/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id){
        Optional<Student> studentData = service.getStudentByID(id);
        System.out.println(studentData);
        System.out.print("Daten angekommen");
        return studentData.map(value ->
                new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("profil/delete_user/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        System.out.println("Lösche user");
        service.deleteStudentbyId(id);
        return "Login";
    }
    @RequestMapping("/chat")
    public String viewChat(){
        return "chat";
    }

//    @RequestMapping("/upload")
//    public String viewTest(){
//        return "upload";
//    }
}
