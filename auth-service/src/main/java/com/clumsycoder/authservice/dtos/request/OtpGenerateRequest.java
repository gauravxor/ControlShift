package com.clumsycoder.authservice.dtos.request;

import com.clumsycoder.controlshift.commons.enums.OtpPurpose;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtpGenerateRequest {
    @NotNull
    private OtpPurpose otpType;
}