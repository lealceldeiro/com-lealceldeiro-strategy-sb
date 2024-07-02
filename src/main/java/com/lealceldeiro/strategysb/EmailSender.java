package com.lealceldeiro.strategysb;

import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
  private static final Logger LOGGER = Logger.getLogger(EmailSender.class.getName());

  @Value("${integration.mailersend.token}")
  private String token;

  public boolean send(String to, String subject, String body) {
    Email email = createEmail(to, subject, body);
    MailerSend sender = createSender();

    return sendEmailUsingSender(sender, email);
  }

  private static Email createEmail(String to, String subject, String body) {
    Email email = new Email();
    email.setFrom("Strategy Pattern In Spring Boot", "comlealceldeiro@strategy.com");

    email.addRecipient(to, to);
    email.setSubject(subject);
    email.setPlain(body);
    return email;
  }

  private MailerSend createSender() {
    MailerSend ms = new MailerSend();
    ms.setToken(token);
    return ms;
  }

  private static boolean sendEmailUsingSender(MailerSend sender, Email email) {
    LOGGER.info("Attempting to sent email ");
    try {
      MailerSendResponse response = sender.emails().send(email);
      LOGGER.info("Sent email with id " + response.messageId);
    } catch (MailerSendException e) {
      LOGGER.warning("Email not sent");
      return false;
    }

    return true;
  }
}
