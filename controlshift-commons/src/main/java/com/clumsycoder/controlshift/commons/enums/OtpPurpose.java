package com.clumsycoder.controlshift.commons.enums;


public enum OtpPurpose {
    EMAIL_VERIFICATION(10 * 60), // 10 minutes
    PASSWORD_RESET(15 * 60);     // 15 minutes

    private final int expiryMinutes;

    OtpPurpose(int expirySeconds) {
        this.expiryMinutes = expirySeconds;
    }

    public int getExpirySeconds() {
        return expiryMinutes;
    }
}