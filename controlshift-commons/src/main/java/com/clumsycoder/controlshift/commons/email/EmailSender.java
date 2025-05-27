package com.clumsycoder.controlshift.commons.email;

public interface EmailSender {
    void sendEmail(String to, EmailContent content);
}