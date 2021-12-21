package com.banquemisr.notifier;

import com.banquemisr.dto.MailDto;
import com.banquemisr.model.Participant;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Component
public class EmailNotifier {
    private final String PORT = "587";
    private final String HOST = "smtp.mailtrap.io";
    private final String USERNAME = "791f92350bfadf";
    private final String PASSWORD = "bf12ba28679363";
    private final String EMAIL = "b88acfcca4-741b1c@inbox.mailtrap.io";

    private final boolean AUTH = true;
    private final boolean STARTTLS = true;

    public void sendEmail(Participant participant) throws MessagingException {
        MailDto mail = new MailDto();
        mail.setMailSubject("League Champion");
        mail.setMailFrom("dev.mohamed.abdelhay@gmail.com");
        mail.setMailTo("dev.mohamed.abdelhay@gmail.com");
        mail.setMailContent("Champion League Winner!" + participant.getName());

        Message msg = new MimeMessage(setSession(setProperties()));

        msg.setSentDate(new Date());
        msg.setSubject("You're the Champion");

        msg.setFrom(new InternetAddress(EMAIL, false));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getMailTo()));

        msg.setContent(mail.getMailContent(), "text/html");

        Transport.send(msg);
    }

    private Session setSession(Properties props) {
        return Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
    }

    private Properties setProperties() {
        Properties props = new Properties();

        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.auth", AUTH);
        props.put("mail.smtp.starttls.enable", STARTTLS);

        return props;
    }
}