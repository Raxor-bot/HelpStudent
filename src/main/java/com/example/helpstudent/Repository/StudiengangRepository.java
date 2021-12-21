package com.example.helpstudent.Repository;

import com.example.helpstudent.Tabellen.Student.Studiengang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudiengangRepository extends JpaRepository<Studiengang, Long> {
    @Override
    List<Studiengang> findAll();
}
