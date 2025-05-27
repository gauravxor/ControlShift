package com.clumsycoder.authservice.controllers;

import com.clumsycoder.authservice.dtos.request.PlayerLoginRequest;
import com.clumsycoder.authservice.dtos.response.PlayerDataResponse;
import com.clumsycoder.authservice.models.Player;
import com.clumsycoder.authservice.services.LoginService;
import com.clumsycoder.controlshift.commons.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody PlayerLoginRequest request) {
        Player player = loginService.login(request);

        PlayerDataResponse dtoResponse = new PlayerDataResponse(
                player.getId(),
                player.getEmail(),
                player.isVerified()
        );

        ApiResponse response = new ApiResponse()
                .message("Logged in successfully")
                .data(Map.of("player", dtoResponse));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}