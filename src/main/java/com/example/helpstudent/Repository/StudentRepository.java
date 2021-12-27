package com.example.helpstudent.Repository;

import com.example.helpstudent.Tabellen.Student.Student;
import com.example.helpstudent.Tabellen.Student.Studiengang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByMail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Student student "+
            "SET student.enabled = TRUE WHERE student.mail = ?1")
    int enableStudent(String mail);

    @Transactional
    @Modifying
    @Query("UPDATE Student student "+"SET student.rolle = 'USER' WHERE student.mail = ?1")
    void setStudentRolleUSER(String mail);

    Optional<Student> findStudentByNlfdstudent(long nlfdstudent);

    @Transactional
    @Modifying
    @Query("UPDATE Student student "+"SET student.studiengang = 1 WHERE student.mail = ?1")
    void setStudentStudienGang(String mail);

    void deleteByMail(String mail);
}