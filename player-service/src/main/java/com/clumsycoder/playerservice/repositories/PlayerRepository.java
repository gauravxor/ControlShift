package com.clumsycoder.playerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clumsycoder.playerservice.models.Player;

public interface PlayerRepository extends JpaRepository<Player, String> {

}