package com.example.helpstudent.Service;

import com.example.helpstudent.Tabellen.Student.Student;
import com.example.helpstudent.Repository.StudentRepository;
import com.example.helpstudent.registrierung.token.BestaetigungsToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService implements UserDetailsService {

    @Autowired
    private final StudentRepository repo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final BestaetigungsTokenService bestaetigungsTokenService;

    @Autowired
    public StudentService(StudentRepository repo,
                          BCryptPasswordEncoder bCryptPasswordEncoder,
                          BestaetigungsTokenService bestaetigungsTokenService) {
        this.repo = repo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.bestaetigungsTokenService = bestaetigungsTokenService;
    }

    public List<Student> getStudents(){
        return repo.findAll();
    }

    public String addNewStudent(Student student) {
        Optional<Student> studentOptional = repo.findStudentByMail(student.getMail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email ist bereits vorhanden");
        }
        String encodedPassword = bCryptPasswordEncoder
                .encode(student.getPassword());
        student.setPasswort(encodedPassword);
        repo.save(student);

        String token = UUID.randomUUID().toString();
        BestaetigungsToken bestaetigungsToken = new BestaetigungsToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15), // 15 min Zeit die Registrierung in der Mail zu bestätigen
                student
        );
        bestaetigungsTokenService.saveBestaetigungsToken(
                bestaetigungsToken);
        return token;
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

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        return repo.findStudentByMail(mail)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Student mit E-Mail %s nicht gefunden!",mail)));
    }

    public int enableStudent(String mail) {
        return repo.enableStudent(mail);
    }
}