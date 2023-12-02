package com.example.wedbansach_springboot_be.service;

public interface EmailService {
    public void sendMessage(String from, String to, String subject, String text);
}
