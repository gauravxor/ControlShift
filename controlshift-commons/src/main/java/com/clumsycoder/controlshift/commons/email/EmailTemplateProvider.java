package com.clumsycoder.controlshift.commons.email;

public interface EmailTemplateProvider {
    EmailContent renderWelcomeTemplate(String name);
}