package com.clumsycoder.playerservice.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerCreateRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

}