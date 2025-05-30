package com.clumsycoder.playerservice.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlayerAuthResponse {
    private String id;
    private String email;
    private String password;

    @JsonProperty("isEmailVerified")
    private boolean isVerified;

}