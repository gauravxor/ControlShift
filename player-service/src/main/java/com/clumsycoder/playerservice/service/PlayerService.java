package com.clumsycoder.playerservice.service;

import com.clumsycoder.controlshift.commons.exceptions.DuplicateResourceException;
import com.clumsycoder.playerservice.dtos.request.PlayerCreateRequest;
import com.clumsycoder.playerservice.models.Player;
import com.clumsycoder.playerservice.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, PasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Player> getPlayerById(String playerId) {
        return playerRepository.findById(playerId);
    }

    public Player createPlayer(PlayerCreateRequest request) {
        try {
            Player player = new Player();
            player.setEmail(request.getEmail());
            player.setPassword(passwordEncoder.encode(request.getPassword()));
            return playerRepository.save(player);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateResourceException("Player already exist");
        }
    }
}