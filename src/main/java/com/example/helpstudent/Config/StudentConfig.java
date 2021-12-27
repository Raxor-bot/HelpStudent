package com.example.helpstudent.Config;

import com.example.helpstudent.Service.StudentService;
import com.example.helpstudent.Tabellen.Student.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class StudentConfig implements CommandLineRunner{
    private final StudentService studentService;

    private final Logger logger = LoggerFactory.getLogger(StudentConfig.class);

    Student jannik = new Student(
              "Markau",
              "Jannik",
              "Jannik.markau01@gmail.com",
              "$2a$10$8dhqPyJEt3ebX5zg.A1YXeor4/A5gDIWdb4Z3ERC0S5mT5RTBqZn2"
              );
    Student armin = new Student(
            "Reimann",
            "Armin",
            "reimann.armin2@gmail.com",
            "passwort123"
    );

    public StudentConfig(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) {
        logger.info("Student wird Konfiguriert");
        studentService.save(jannik);
        studentService.enableStudent("Jannik.markau01@gmail.com");
        studentService.setStudentRolleUSER("Jannik.markau01@gmail.com");
        studentService.save(armin);
        studentService.enableStudent("reimann.armin2@gmail.com");
        logger.info("Student wurde fertiggestellt");
    }
}
