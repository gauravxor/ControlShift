package com.clumsycoder.playerservice.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlayerCreateResponse {
    private String id;
    private String email;
    private boolean isVerified;
}