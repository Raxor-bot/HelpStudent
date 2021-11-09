package com.example.helpstudent.Repository;

import com.example.helpstudent.registrierung.token.BestaetigungsToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface BestaetigungsTokenRepository extends JpaRepository<BestaetigungsToken, Long> {

    Optional<BestaetigungsToken> findByToken(String token);

    @Transactional
    @Modifying
    @Query("UPDATE BestaetigungsToken c " +
            "SET c.bestaetigtUm = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);
}