package com.clumsycoder.authservice.services;

import com.clumsycoder.authservice.clients.PlayerServiceClient;
import com.clumsycoder.authservice.dto.common.Player;
import com.clumsycoder.authservice.dto.request.PlayerSignupRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignupService {
    private final OtpService otpService;
    private final PlayerServiceClient playerServiceClient;

    public Player createPlayer(PlayerSignupRequest request) {
        Player newPlayer = playerServiceClient.createPlayer(request);
        otpService.sendEmailVerificationOtp(newPlayer.getEmail(), newPlayer.getId());
        return newPlayer;
    }
}