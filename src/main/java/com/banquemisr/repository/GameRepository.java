package com.banquemisr.repository;

import com.banquemisr.model.Game;
import com.banquemisr.model.Round;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByRound(Round round);
}
