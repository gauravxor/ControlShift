package com.clumsycoder.authservice.repositories;

import com.clumsycoder.authservice.models.Player;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, String> {

    Optional<Player> findByEmail(@Email @NotBlank String email);
}