package com.clumsycoder.controlshift.commons.email.sendgrid;

import com.clumsycoder.controlshift.commons.email.EmailContent;
import com.clumsycoder.controlshift.commons.email.EmailSender;
import com.clumsycoder.controlshift.commons.email.EmailService;
import com.clumsycoder.controlshift.commons.email.EmailTemplateProvider;

public class SendGridEmailService implements EmailService {

    private final EmailSender emailSender;
    private final EmailTemplateProvider templateProvider;

    public SendGridEmailService(EmailSender emailSender, EmailTemplateProvider templateProvider) {
        this.emailSender = emailSender;
        this.templateProvider = templateProvider;
    }

    @Override
    public void sendWelcomeEmail(String to, String name) {
        EmailContent emailContent = templateProvider.renderWelcomeTemplate(name);
        System.out.println("to = " + to + ", name = " + name);
        emailSender.sendEmail(to, emailContent);
    }

    @Override
    public void sendVerificationOtp(String to, String otp) {
        EmailContent emailContent = templateProvider.renderEmailVerificationTemplate(otp);
        System.out.println("SendGridEmailService.sendVerificationOtp");
        System.out.println("to = " + to + ", otp = " + otp);
        emailSender.sendEmail(to, emailContent);
    }
}