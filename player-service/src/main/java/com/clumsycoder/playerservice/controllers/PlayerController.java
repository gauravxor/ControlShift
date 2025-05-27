package com.clumsycoder.playerservice.controllers;

import com.clumsycoder.controlshift.commons.exceptions.ResourceNotFoundException;
import com.clumsycoder.controlshift.commons.response.ApiResponse;
import com.clumsycoder.playerservice.dtos.request.PlayerCreateRequest;
import com.clumsycoder.playerservice.dtos.response.PlayerDataResponse;
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

import java.util.Map;
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
    public ResponseEntity<ApiResponse> getPlayer(@PathVariable String id) {
        Optional<Player> playerOpt = playerService.getPlayerById(id);
        if (playerOpt.isEmpty()) {
            throw new ResourceNotFoundException("Player does not exist");
        }
        Player player = playerOpt.get();
        PlayerDataResponse responseDto = new PlayerDataResponse(
                player.getId(),
                player.getEmail(),
                player.isVerified()
        );
        ApiResponse response = new ApiResponse()
                .message("Player found")
                .data(Map.of("player", responseDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createPlayer(@Valid @RequestBody PlayerCreateRequest request) {
        Player newPlayer = playerService.createPlayer(request);
        PlayerDataResponse responseDto = new PlayerDataResponse(
                newPlayer.getId(),
                newPlayer.getEmail(),
                newPlayer.isVerified()
        );
        ApiResponse response = new ApiResponse()
                .message("Player created")
                .data(Map.of("player", responseDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}