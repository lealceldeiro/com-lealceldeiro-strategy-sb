package com.lealceldeiro.strategysb;

public interface EmailSender {
  boolean send(String to, String subject, String body);
}
