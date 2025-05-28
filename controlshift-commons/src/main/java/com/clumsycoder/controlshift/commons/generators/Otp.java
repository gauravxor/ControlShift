package com.clumsycoder.controlshift.commons.generators;

import com.clumsycoder.controlshift.commons.enums.OtpType;

import java.security.InvalidParameterException;
import java.security.SecureRandom;

public class Otp {
    private static final String DIGITS = "0123456789";
    private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHANUMERIC = DIGITS + ALPHABETS;
    private static final int DEFAULT_LENGTH = 6;

    private Otp() {
    }

    public static String generate(OtpType type) {
        return generate(type, DEFAULT_LENGTH);
    }

    public static String generate(OtpType type, int length) {
        if (length <= 0) {
            throw new InvalidParameterException("OTP length must be greater than 0");
        }

        String chars;

        switch (type) {
            case NUMERIC -> chars = DIGITS;
            case ALPHABETIC -> chars = ALPHABETS;
            case ALPHANUMERIC -> chars = ALPHANUMERIC;
            default -> throw new IllegalArgumentException("Unsupported OTP type: " + type);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            otp.append(chars.charAt(random.nextInt(chars.length())));
        }
        return otp.toString();
    }
}