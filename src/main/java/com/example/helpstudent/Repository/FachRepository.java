package com.example.helpstudent.Repository;

import com.example.helpstudent.Tabellen.Student.Fach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FachRepository extends JpaRepository<Fach, Long> {
    Fach getFachByFachName(String name);
}
