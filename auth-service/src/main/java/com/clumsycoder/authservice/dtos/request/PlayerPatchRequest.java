package com.clumsycoder.authservice.dtos.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PlayerPatchRequest {
    private String email;
    private boolean isEmailVerified;
}