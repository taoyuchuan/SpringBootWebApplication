package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * Controller class for sending email.
 */
@Controller
public class EmailController {

    /**
     * Map send email request.
     * @return Send email view.
     * @throws IOException Throws IO Exception.
     * @throws MessagingException Throws email message exception.
     */
    @RequestMapping(value = "/sendemail")
    public String sendEmail() throws IOException, MessagingException {
        sendmail();
        return "email";
    }

    /**
     * Private function to send an email.
     * @throws AddressException Throws email address incorrect exception.
     * @throws MessagingException Throws email message exception.
     * @throws IOException Throws IO Exception.
     */
    private void sendmail() throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");


        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("yourgmail@gmail.com", "<your password>");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("yourgmail@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("yourgmail@gmail.com"));
        msg.setSubject("email");
        msg.setContent("email", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("This is a test email", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.attachFile("/var/tmp/image.png");
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }
}

