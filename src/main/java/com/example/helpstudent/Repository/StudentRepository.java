package com.example.helpstudent.Repository;

import com.example.helpstudent.Tabellen.Fach;
import com.example.helpstudent.Tabellen.Student;
import com.example.helpstudent.Tabellen.Studiengang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    void deleteByNlfdstudent(long id);

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

    /*@Transactional
    @Modifying
    @Query("UPDATE Student student "+"SET student.staerken = ?1 WHERE student.nlfdstudent = ?2")
    void setStudentStaerken(List<Fach> fachListstark, Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Student student "+"SET student.schwaechen = ?1 WHERE student.nlfdstudent = ?2")
    void setStudentSchwaechen(List<Fach> fachListschwach, Long id);*/

    @Modifying
    @Query(value = "INSERT INTO student_staerken(staerken_nlfd_fach, student_nlfdstudent) VALUES (:fach,:id)", nativeQuery = true)
    @Transactional
    void setStudentStaerken(@Param("fach") Fach fach, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Student student "+"SET student.geburtstag = ?1 WHERE student.nlfdstudent = ?2")
    void setStudentGeburtstag(LocalDate geburtstag, Long id);


    @Modifying
    @Query(value = "INSERT INTO student_schwaechen(schwaechen_nlfd_fach, student_nlfdstudent) VALUES (:fach,:id)", nativeQuery = true)
    @Transactional
    void setStudentSchwaechen(@Param("fach") Fach fach,@Param("id") long studentid);


    @Transactional
    @Modifying
    @Query(value = "delete from student_schwaechen where student_nlfdstudent = ?1", nativeQuery = true)
    void deleteStudentSchwaechen(long studentid);

    @Transactional
    @Modifying
    @Query(value = "delete from student_staerken where student_nlfdstudent = ?1", nativeQuery = true)
    void deleteStudentStaerken(long studentid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO gruppe_student_gruppen(gruppen_id, student_gruppen_nlfdstudent) VALUES (:gruppenid,:studentid)", nativeQuery = true)
    void addStudentGruppe(@Param("studentid")long studentid, @Param("gruppenid")long gruppenid);

    @Transactional
    @Modifying
    @Query(value = "DELETE from gruppe_student_gruppen WHERE gruppen_id = :gruppenid AND student_gruppen_nlfdstudent = :studentid", nativeQuery = true)
    void removeStudentGruppe(@Param("studentid")long studentid, @Param("gruppenid")long gruppenid);
}