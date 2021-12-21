package com.banquemisr.repository;

import com.banquemisr.model.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoundRepository extends JpaRepository<Round, Long> {
    @Query("SELECT round from Round round where round.isActive = :active")
    Optional<Round> getActiveRound(@Param("active") boolean active);
}
