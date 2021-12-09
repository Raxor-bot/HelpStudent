package com.example.helpstudent.Service;

import com.example.helpstudent.Tabellen.Student.Student;
import com.example.helpstudent.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repo;

    @Autowired
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getStudents(){
        return repo.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = repo.findStudentByMail(student.getMail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email ist bereits vorhanden");
        }
        repo.save(student);
        System.out.println(student);
    }

    public void deleteStudent(String mail) {
        Long id = repo.findStudentByMail(mail).get().getNlfdstudent();
        if (!repo.existsById(id)){
            throw new IllegalStateException(
                    "Der Student mit der ID: "+id+" existiert nicht"
            );
        }
        repo.deleteById(repo.findStudentByMail(mail).get().getNlfdstudent());
    }


    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = repo.findById(studentId).orElseThrow(()-> new IllegalStateException(
                "Der Student mit der ID: "+studentId+" existiert nicht"
        ));

        if(name != null && name.length() > 0 && !Objects.equals(student.getSname(), name)){
            student.setSname(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getMail(), email)){
            this.checkMail(email);
            student.setMail(email);
        }
    }

    private void checkMail(String email){
        if(repo.findStudentByMail(email).isPresent()){
            throw new IllegalStateException("Email ist bereits vorhanden");
        }
    }

    public Optional<Student> getStudent(Long id){
       return repo.findStudentByNlfdstudent(id);
    }
}