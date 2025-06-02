package com.clumsycoder.authservice.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String id;
    private String email;

    @JsonProperty("isEmailVerified")
    private boolean isEmailVerified;
}