package com.lealceldeiro.strategysb;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("email")
public class EmailController {
  private final EmailSender emailSender;

  public EmailController(EmailSender emailSender) {
    this.emailSender = emailSender;
  }

  @PostMapping("/send")
  public String sendEmail(@RequestBody EmailRequestDto request) {
    boolean success = emailSender.send(request.to(), request.subject(), request.body());
    return success ? "Email sent" : "Error sending email";
  }
}

