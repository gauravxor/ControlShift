package com.clumsycoder.authservice.dtos.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String id;
    private String email;

    @JsonProperty("isEmailVerified")
    private boolean isEmailVerified;
}