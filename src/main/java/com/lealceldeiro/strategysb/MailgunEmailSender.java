package com.lealceldeiro.strategysb;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("mailgun")
@Component
public class MailgunEmailSender implements EmailSender {

  @Override
  public boolean send(String to, String subject, String body) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
