package com.clumsycoder.controlshift.commons.email;

public abstract class DefaultEmailTemplateProvider implements EmailTemplateProvider {
    @Override
    public EmailContent renderWelcomeTemplate(String name) {
        return new EmailContent("Welcome to ControlShift", "Thanks for onboarding to ControlShift");
    }
}