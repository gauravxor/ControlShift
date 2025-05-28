package com.clumsycoder.authservice.services;

import com.clumsycoder.authservice.dtos.request.PlayerSignupRequest;
import com.clumsycoder.authservice.models.Player;
import com.clumsycoder.authservice.repositories.PlayerRepository;
import com.clumsycoder.controlshift.commons.email.EmailService;
import com.clumsycoder.controlshift.commons.enums.OtpType;
import com.clumsycoder.controlshift.commons.exceptions.DuplicateResourceException;
import com.clumsycoder.controlshift.commons.generators.Otp;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignupService {
    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public Player createPlayer(PlayerSignupRequest request) {
        try {
            Player player = new Player();
            player.setEmail(request.getEmail());
            player.setPassword(passwordEncoder.encode(request.getPassword()));
            Player newPlayer = playerRepository.save(player);
            emailService.sendVerificationOtp(newPlayer.getEmail(), Otp.generate(OtpType.ALPHANUMERIC));
            return newPlayer;
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateResourceException("Player already exist.");
        }
    }
}