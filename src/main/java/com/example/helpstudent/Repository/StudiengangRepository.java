package com.example.helpstudent.Repository;

import com.example.helpstudent.Tabellen.Studiengang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


public interface StudiengangRepository extends JpaRepository<Studiengang, Long> {
    @Override
    List<Studiengang> findAll();

    Studiengang getStudiengangsByStudiengangid(Long studiengangid);

    @Transactional
    @Query("select stdgang from Studiengang stdgang " +
            "where stdgang.stName = ?1")
    Studiengang getStudiengangByStName(String stName);
}
