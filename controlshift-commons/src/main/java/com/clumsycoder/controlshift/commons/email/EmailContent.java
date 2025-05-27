package com.clumsycoder.controlshift.commons.email;

public class EmailContent {
    private final String subject;
    private final String body;

    public EmailContent(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getBody() {
        return this.body;
    }
}