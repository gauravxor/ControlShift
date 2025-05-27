package com.clumsycoder.authservice.controllers;

import com.clumsycoder.authservice.dtos.request.PlayerSignupRequest;
import com.clumsycoder.authservice.dtos.response.PlayerDataResponse;
import com.clumsycoder.authservice.models.Player;
import com.clumsycoder.authservice.services.SignupService;
import com.clumsycoder.controlshift.commons.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth/signup")
public class SignupController {
    private final SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> signup(@Valid @RequestBody PlayerSignupRequest request) {
        Player newPlayer = signupService.createPlayer(request);
        PlayerDataResponse responseDto = new PlayerDataResponse(
                newPlayer.getId(),
                newPlayer.getEmail(),
                newPlayer.isEmailVerified()
        );
        ApiResponse response = new ApiResponse()
                .message("Player created")
                .data(Map.of("player", responseDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

}