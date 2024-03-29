package com.example.helpstudent.Service;

import com.example.helpstudent.Tabellen.Fach;
import com.example.helpstudent.Tabellen.Gruppe;
import com.example.helpstudent.Tabellen.Student;
import com.example.helpstudent.Repository.StudentRepository;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class StudentService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private final StudentRepository repo;

    private final StudiengangService studiengangService;


    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final BestaetigungsTokenService bestaetigungsTokenService;
    private final FachService fachService;

    @Autowired
    public StudentService(StudentRepository repo,
                          StudiengangService studiengangService, BCryptPasswordEncoder bCryptPasswordEncoder,
                          BestaetigungsTokenService bestaetigungsTokenService, FachService fachService) {
        this.repo = repo;
        this.studiengangService = studiengangService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.bestaetigungsTokenService = bestaetigungsTokenService;
        this.fachService = fachService;
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

    public void deleteStudentbyId(long id) {
        logger.info("Student wird gelöscht" + id);
        if(repo.findStudentByNlfdstudent(id).isPresent()) {
            logger.info("Student wurde erfolgreich gelöscht");
            repo.deleteById(repo.findStudentByNlfdstudent(id).get().getNlfdstudent());
        }
        else{
           logger.info("Student ist nicht vorhanden");
            throw new IllegalStateException(
                    "Der Student mit der mail: " + id + " existiert nicht"
            );
        }
    }

    public void addStudentGruppe(Student student, Gruppe gruppe){
        if(!student.getGruppen().contains(gruppe)) {
            repo.addStudentGruppe(student.getNlfdstudent(), gruppe.getGruppenId());
        }
    }


    public void removeStudentGruppe(Student student, Gruppe gruppe) {
        logger.info("lösche Gruppe"+gruppe.getGruppenname());
            repo.removeStudentGruppe(student.getNlfdstudent(), gruppe.getGruppenId());
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

    public void setStudentBilderPfad(String bilderPfad,Long id){
        repo.setStudentBilderPfad(bilderPfad, id);
    }



    public void save(Student student){
        repo.save(student);
    }

    public void setStudentRolleUSER(String s) {
        repo.setStudentRolleUSER(s);
    }

    public void UpdateUser(Map<String, Object> studentdata, long studentid) {

        logger.info(studentdata.toString());
        if (studentdata.get("geburtstag") != "") {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            formatter.withLocale(Locale.GERMANY);
            LocalDate date = LocalDate.parse((String) studentdata.get("geburtstag"), formatter);

            repo.setStudentGeburtstag(date, studentid);
        }

        if (studentdata.get("geschlecht") != "") {
            repo.setStudentgeschlecht((String) studentdata.get("geschlecht"), studentid);
        }

        //todo wichtig jannik das ist doof weil ganz viele errors
        // z.B.: java.lang.ClassCastException: class java.util.LinkedHashMap cannot be cast to class java.lang.Number (java.util.LinkedHashMap and java.lang.Number are in module java.base of loader 'bootstrap')
        if (studentdata.get("studiengang") != "" && studentdata.get("studiengang") != null) {
            System.out.println("#############################################");
            System.out.println(studentdata.get("studiengang"));
            long studiengangId = ((Number) studentdata.get("studiengang")).longValue();

            System.out.println("----------------------------+++++++++++++++-----------------------");
            System.out.println(studiengangId);
            repo.setStudentStudiengang(studiengangService.getStudiengangById(studiengangId), studentid);
        }

        if (studentdata.get("semester") != "") {
            int semester = Integer.parseInt(studentdata.get("semester").toString());

            if (semester > 0) {
                repo.setStudentnSemester(semester, studentid);
            }
        }

        if (studentdata.get("schwaechen") != null) {
            if (!studentdata.get("staerken").toString().equals("[]")) {
                logger.info("stark");

                repo.deleteStudentStaerken(studentid);

                String staerkenstr = studentdata.get("staerken").toString();

                logger.info(studentdata.get("staerken").toString());

                List<Fach> faecher = convertArray(staerkenstr);

                for (Fach fach : faecher) {
                    repo.setStudentStaerken(fach, studentid);
                }
            }
        }

        if (studentdata.get("schwaechen") != null) {
            if (!studentdata.get("schwaechen").toString().equals("[]")) {
                repo.deleteStudentSchwaechen(studentid);

                logger.info("schwach");
                String schwaechenstr = studentdata.get("schwaechen").toString();

                List<Fach> fachList = convertArray(schwaechenstr);

                for (Fach fach : fachList) {
                    repo.setStudentSchwaechen(fach, studentid);
                }
            }
        }
    }

    private List<Fach> convertArray(String fachstr) {
        List<Fach> faecher = new ArrayList<>();
        long[] arr = Arrays.stream(fachstr.substring(1, fachstr.length() - 1)
                .split(","))
                .map(String::trim)
                .mapToLong(Long::parseLong)
                .toArray();


        for (long num : arr) {
            faecher.add(fachService.getFachById(num));
        }
        return faecher;
    }
}