package com.clumsycoder.authservice.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtpValidationRequest {

    @NotBlank
    private String playerId;

    @NotBlank
    private String otpCode;
}