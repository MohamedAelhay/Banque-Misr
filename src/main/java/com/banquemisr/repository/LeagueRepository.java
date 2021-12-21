package com.banquemisr.repository;

import com.banquemisr.model.League;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
}
