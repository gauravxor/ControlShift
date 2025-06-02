package com.clumsycoder.authservice.services;

import com.clumsycoder.authservice.clients.PlayerServiceClient;
import com.clumsycoder.authservice.dto.common.Player;
import com.clumsycoder.authservice.dto.internal.PlayerAuthResponse;
import com.clumsycoder.authservice.dto.request.PlayerLoginRequest;
import com.clumsycoder.authservice.services.exceptions.FeignExceptionHandler;
import com.clumsycoder.controlshift.commons.exceptions.UnauthorizedException;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {
    private final PlayerServiceClient playerServiceClient;
    private final PasswordEncoder passwordEncoder;
    private final FeignExceptionHandler feignExceptionHandler;

    public Player login(PlayerLoginRequest request) {
        try {

            PlayerAuthResponse playerAuth = playerServiceClient.getPlayerAuthDataByEmail(request.getEmail());

            String rawPassword = request.getPassword();
            System.out.println("Raw password = " + rawPassword);
            String encodedPassword = playerAuth.getPassword();
            System.out.println("Encoded password = " + encodedPassword);

            if (passwordEncoder.matches(rawPassword, encodedPassword)) {
                return new Player(
                        playerAuth.getEmail(),
                        playerAuth.getId(),
                        playerAuth.getIsEmailVerified()
                );
            }
            throw new UnauthorizedException("Invalid password provided");

        } catch (FeignException e) {
            throw feignExceptionHandler.handle(e);
        }
    }
}