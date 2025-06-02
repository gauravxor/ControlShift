package com.clumsycoder.controlshift.commons.email.sendgrid;

import com.clumsycoder.controlshift.commons.email.EmailContent;
import com.clumsycoder.controlshift.commons.email.EmailSender;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class SendGridEmailSender implements EmailSender {
    private final String fromEmail;
    private final String apiKey;

    public SendGridEmailSender(String apiKey, String fromEmail) {
        this.fromEmail = fromEmail;
        this.apiKey = apiKey;
    }

    @Override
    public void sendEmail(String to, EmailContent emailContent) {
        Mail mail = new Mail(
                new Email(this.fromEmail),
                emailContent.getSubject(),
                new Email(to),
                new Content("text/plain", emailContent.getBody())
        );

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sg.api(request);

            // todo: log the email sending part
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}