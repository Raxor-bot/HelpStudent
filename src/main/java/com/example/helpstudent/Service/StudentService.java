package com.example.helpstudent.Service;

import com.example.helpstudent.Tabellen.Student.Student;
import com.example.helpstudent.Repository.StudentRepository;
import com.example.helpstudent.Tabellen.Student.Studiengang;
import com.example.helpstudent.registrierung.token.BestaetigungsToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(StudentService.class);

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

    public Optional<Student> getStudentByID(Long id){
        return repo.findById(id);
    }


    public String addNewStudent(Student student) {
        logger.info("Neuer Student wird angelegt");

        Optional<Student> studentOptional = repo.findStudentByMail(student.getMail());

        if (studentOptional.isPresent()){
            throw new IllegalStateException("E-mail ist bereits vorhanden!");
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
        logger.info("Student wird gelöscht" + mail);


        if(repo.findStudentByMail(mail).isPresent()) {
            logger.info("Student wurde erfolgreich gelöscht");

            repo.deleteByMail(repo.findStudentByMail(mail).get().getMail());
        }

        else{
           logger.info("Student ist nicht vorhanden");

            throw new IllegalStateException(
                    "Der Student mit der mail: " + mail + " existiert nicht"
            );
        }
    }


    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        logger.info("Student wird geupdatet");

        Student student = repo.findById(studentId).orElseThrow(()-> new IllegalStateException(
                "Der Student mit der ID: "+studentId+" existiert nicht"
        ));

        if(nameGueltig(student,name)){
            student.setSname(name);
        }

        if(emailGueltig(student, email)){
            this.checkMail(email);
            student.setMail(email);
        }
    }

    private void checkMail(String email){
        if(repo.findStudentByMail(email).isPresent()){
            throw new IllegalStateException("Email ist bereits vorhanden");
        }
    }

    private Boolean nameGueltig(Student student, String name){
        return name != null && name.length() > 0 && !Objects.equals(student.getSname(), name);
    }

    private Boolean emailGueltig(Student student, String email){
        return email != null && email.length() > 0 && !Objects.equals(student.getMail(), email);
    }



    public Optional<Student> getStudentById(Long id){
       return repo.findStudentByNlfdstudent(id);
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        return repo.findStudentByMail(mail)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Student mit E-Mail %s nicht gefunden!",mail)));
    }

    public int enableStudent(String mail) {
        repo.setStudentRolleUSER(mail);
        return repo.enableStudent(mail);
    }



    public void save(Student student){
        repo.save(student);
    }

    public void setStudentRolleUSER(String s) {
        repo.setStudentRolleUSER(s);
    }
}