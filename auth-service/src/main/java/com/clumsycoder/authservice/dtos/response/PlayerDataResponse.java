package com.clumsycoder.authservice.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlayerDataResponse {
    private String id;
    private String email;

    @JsonProperty("isEmailVerified")
    private boolean isEmailVerified;
}