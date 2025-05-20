package com.clumsycoder.controlshift.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PingController {
    @GetMapping("/ping")
    public Map<String, String> ping() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "ok");
        return status;
    }
}