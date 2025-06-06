package com.example.NotificationDispatcher.service;

import com.example.NotificationDispatcher.dto.RequestContactTopic;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

import static java.rmi.server.LogStream.log;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(RequestContactTopic requestContactTopic) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@email.com");
        message.setTo(requestContactTopic.getEmail());
        message.setSubject("Notification from Payment Flow - Confirmation of Payment");
        message.setText(
                "Dear " + requestContactTopic.getClientName() + ",\n\n" +
                        "We are pleased to inform you that your payment has been successfully processed.\n\n" +
                        "Transaction Details:\n" +
                        "Payment ID: " + requestContactTopic.getPaymentId() + "\n" +
                        "Amount: $" + requestContactTopic.getAmount() + "\n" +
                        "Payment Method: " + requestContactTopic.getPaymentMethod() + "\n" +
                        "Client Name: " + requestContactTopic.getClientName() + "\n\n" +
                        "Thank you for your payment.\n\n" +
                        "Best regards,\n" +
                        "Payment Flow Team"
        );


        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            System.out.println("Error sending email: " + e.getMessage());
            throw new RuntimeException("Failed to send email", e);
        }


    }


}
