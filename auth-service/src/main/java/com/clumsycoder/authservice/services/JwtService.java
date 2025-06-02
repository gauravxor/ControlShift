package com.clumsycoder.authservice.services;

import com.clumsycoder.authservice.dto.common.Player;
import com.clumsycoder.controlshift.commons.security.Jwt;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    public String createAccessToken(Player player) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("playerId", player.getId());
        claims.put("email", player.getEmail());
        return Jwt.issue(claims);
    }
}