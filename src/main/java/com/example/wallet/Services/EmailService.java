package com.example.wallet.Services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailServiceInterface {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;

    }

    @Async
    @Override
    public void sendEmail(String token, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            String link = "http://localhost:8080/api/v1/auth/verify?token=" + token;

            String htmlContent = "<h3>Verify your email</h3>" +
                    "<p>Click the link below to activate your account:</p>" +
                    "<a href=\"" + link + "\">Activate Account</a>";

            helper.setText(htmlContent, true); // 'true' enables HTML
            helper.setTo(email);
            helper.setSubject("Confirm your Registration");
            helper.setFrom("no-reply@yourdomain.com");

            mailSender.send(mimeMessage);
        }catch (MessagingException exception){
            throw new IllegalStateException("Failed to send email", exception);
        }

    }
}