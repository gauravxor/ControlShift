package com.clumsycoder.playerservice.controllers;

import com.clumsycoder.controlshift.commons.exceptions.ResourceNotFoundException;
import com.clumsycoder.controlshift.commons.response.ApiResponse;
import com.clumsycoder.playerservice.dto.common.PlayerDataResponse;
import com.clumsycoder.playerservice.dto.request.CreatePlayerRequest;
import com.clumsycoder.playerservice.dto.request.PlayerUpdateRequest;
import com.clumsycoder.playerservice.dto.response.PlayerAuthResponse;
import com.clumsycoder.playerservice.models.Player;
import com.clumsycoder.playerservice.service.PlayerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.CompositeUriComponentsContributor;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/player")
@AllArgsConstructor
public class PlayerController {
    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    private final PlayerService playerService;
    private final CompositeUriComponentsContributor compositeUriComponentsContributor;

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
                player.isEmailVerified()
        );
        ApiResponse response = new ApiResponse()
                .message("Player found")
                .data(Map.of("player", responseDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{email}/auth")
    public ResponseEntity<PlayerAuthResponse> getPlayerByEmail(@PathVariable String email) {
        Optional<Player> playerOpt = playerService.getPlayerByEmail(email);
        if (playerOpt.isEmpty()) {
            throw new ResourceNotFoundException("Player does not exist");
        }

        Player player = playerOpt.get();

        PlayerAuthResponse response = new PlayerAuthResponse(
                player.getId(),
                player.getEmail(),
                player.getPassword(),
                player.isEmailVerified()
        );
//        ApiResponse response = new ApiResponse()
//                .message("Player found")
//                .data(Map.of("player", responseDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlayerDataResponse> createPlayer(@Valid @RequestBody CreatePlayerRequest request) {
        Player newPlayer = playerService.createPlayer(request);
        PlayerDataResponse responseDto = new PlayerDataResponse(
                newPlayer.getId(),
                newPlayer.getEmail(),
                newPlayer.isEmailVerified()
        );
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse> updatePlayer(@PathVariable String id, @RequestBody PlayerUpdateRequest request) {

        Player updatedPlayer = playerService.updatePlayer(id, request);
        PlayerDataResponse responseDto = new PlayerDataResponse(
                updatedPlayer.getId(),
                updatedPlayer.getEmail(),
                updatedPlayer.isEmailVerified()
        );
        ApiResponse response = new ApiResponse()
                .message("Player updated")
                .data(Map.of("player", responseDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}