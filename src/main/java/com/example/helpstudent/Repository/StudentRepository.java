package com.example.helpstudent.Repository;

import com.example.helpstudent.Tabellen.Student.Fach;
import com.example.helpstudent.Tabellen.Student.Student;
import com.example.helpstudent.Tabellen.Student.Studiengang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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

    void deleteByMail(String mail);

    @Transactional
    @Modifying
    @Query("UPDATE Student student "+"SET student.bilderpfad = ?1 WHERE student.nlfdstudent = ?2")
    void setStudentBilderPfad(String bilderPfad, Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Student student "+"SET student.geschlecht = ?1 WHERE student.nlfdstudent = ?2")
    void setStudentgeschlecht(String geschlecht, Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Student student "+"SET student.studiengang = ?1 WHERE student.nlfdstudent = ?2")
    void setStudentStudiengang(Studiengang studiengang, Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Student student "+"SET student.nsemester = ?1 WHERE student.nlfdstudent = ?2")
    void setStudentnSemester(int semester, Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Student student "+"SET student.starken = ?1 WHERE student.nlfdstudent = ?2")
    void setStudentStaerken(List<Fach> fachListstark, Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Student student "+"SET student.schwaechen = ?1 WHERE student.nlfdstudent = ?2")
    void setStudentSchwaechen(List<Fach> fachListschwach, Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Student student "+"SET student.geburtstag = ?1 WHERE student.nlfdstudent = ?2")
    void setStudentGeburtstag(LocalDate geburtstag, Long id);
}