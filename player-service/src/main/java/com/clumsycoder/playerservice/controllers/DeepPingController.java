package com.clumsycoder.playerservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;
import java.util.HashMap;

@RestController
public class DeepPingController {
    @GetMapping("/deep-ping")
    public Map<String, String> deepPing() {
        Map<String, String> response = new HashMap<>();
        response.put("deepPingStatus", "OK");
        return response;
    }
}