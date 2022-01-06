package com.example.helpstudent.Repository;

import com.example.helpstudent.Tabellen.Student.Studiengang;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface StudiengangRepository extends JpaRepository<Studiengang, Long> {
    @Override
    List<Studiengang> findAll();

    Studiengang getStudiengangsByStudiengangid(Long studiengangid);

    @Transactional
    @Query("select stdgang from Studiengang stdgang " +
            "where stdgang.stName = ?1")
    Studiengang getStudiengangByStName(String stName);
}
