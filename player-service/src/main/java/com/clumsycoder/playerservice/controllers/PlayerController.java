package com.clumsycoder.playerservice.controllers;

import com.clumsycoder.playerservice.dtos.request.PlayerCreateRequest;
import com.clumsycoder.playerservice.dtos.response.PlayerCreateResponse;
import com.clumsycoder.playerservice.models.Player;
import com.clumsycoder.playerservice.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clumsycoder.controlshift.commons.response.ApiResponse;

import java.util.Optional;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<Player>>> getPlayer(@PathVariable String id) {
        Optional<Player> player = playerService.getPlayerById(id);
        if (player.isEmpty()) {
            ApiResponse<Optional<Player>> errorResponse = new ApiResponse<Optional<Player>>()
                    .message("Player not found");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        ApiResponse<Optional<Player>> response = new ApiResponse<Optional<Player>>()
                .message("Player found")
                .data(player);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PlayerCreateResponse>> createPlayer(@Valid @RequestBody PlayerCreateRequest request) {
        Player newPlayer = playerService.createPlayer(request);
        PlayerCreateResponse responseDto = new PlayerCreateResponse(
                newPlayer.getId(),
                newPlayer.getEmail(),
                newPlayer.isVerified()
        );
        ApiResponse<PlayerCreateResponse> response = new ApiResponse<PlayerCreateResponse>()
                .message("Player created")
                .data(responseDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}