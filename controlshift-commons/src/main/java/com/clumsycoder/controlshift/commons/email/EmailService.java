package com.clumsycoder.controlshift.commons.email;

public interface EmailService {
    void sendWelcomeEmail(String to, String name);
}