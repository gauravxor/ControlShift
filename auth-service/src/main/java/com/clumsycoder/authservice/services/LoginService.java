package com.clumsycoder.authservice.services;

import com.clumsycoder.authservice.dtos.request.PlayerLoginRequest;
import com.clumsycoder.authservice.models.Player;
import com.clumsycoder.authservice.repositories.PlayerRepository;
import com.clumsycoder.controlshift.commons.exceptions.DatabaseException;
import com.clumsycoder.controlshift.commons.exceptions.ResourceNotFoundException;
import com.clumsycoder.controlshift.commons.exceptions.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {
    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;

    public Player login(PlayerLoginRequest request) {
        try {
            Optional<Player> playerOpt = playerRepository.findByEmail(request.getEmail());

            if (playerOpt.isEmpty()) {
                throw new ResourceNotFoundException("Player does not exist.");
            }

            Player player = playerOpt.get();

            String rawPassword = request.getPassword();
            String encodedPassword = player.getPassword();

            if (passwordEncoder.matches(rawPassword, encodedPassword)) {
                return player;
            }
            throw new UnauthorizedException("Invalid password provided");

        } catch (DatabaseException e) {
            throw new DatabaseException("Database fucked up");
        }
    }
}