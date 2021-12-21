package com.example.helpstudent.Repository;

import com.example.helpstudent.Tabellen.Student.Gruppe;
import com.example.helpstudent.Tabellen.Student.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface GruppenRepository extends JpaRepository<Gruppe, Long> {

}