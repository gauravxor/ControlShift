package com.clumsycoder.controlshift.commons.email;

public abstract class DefaultEmailTemplateProvider implements EmailTemplateProvider {
    @Override
    public EmailContent renderWelcomeTemplate(String name) {
        return new EmailContent("Welcome to ControlShift", "Thanks for onboarding to ControlShift");
    }

    @Override
    public EmailContent renderEmailVerificationTemplate(String otp) {
        return new EmailContent("Please verify your email", "Use this otp to verify your email. \n OTP = " + otp);
    }
}