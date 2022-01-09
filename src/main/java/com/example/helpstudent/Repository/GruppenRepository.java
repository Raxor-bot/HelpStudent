package com.example.helpstudent.Repository;

import com.example.helpstudent.Tabellen.Student.Gruppe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface GruppenRepository extends JpaRepository<Gruppe, Long> {

    Optional<Gruppe> findByGruppenname(String gruppenname);

    Optional<Gruppe> findGruppeById(long id);

}