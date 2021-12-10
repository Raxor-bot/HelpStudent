package com.example.helpstudent.Repository;

import com.example.helpstudent.registrierung.token.TokenError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenErrorRepository extends JpaRepository<TokenError , Long> {
    @Override
    Optional<TokenError> findById(Long l);

    Optional<TokenError> findByToken(String token);

}
