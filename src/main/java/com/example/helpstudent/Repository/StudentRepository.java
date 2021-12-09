package com.example.helpstudent.Repository;

import com.example.helpstudent.Tabellen.Student.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByMail(String email);

    Optional<Student> findStudentByNlfdstudent(long nlfdstudent);
}