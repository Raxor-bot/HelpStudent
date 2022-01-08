package com.example.helpstudent.Repository;

import com.example.helpstudent.Tabellen.Student.Fach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FachRepository extends JpaRepository<Fach, Long> {
    @Override
    List<Fach> findAll();

    Fach getFachByFachName(String name);

    Fach getFachByNlfdFach(long nlfdFach);
}
