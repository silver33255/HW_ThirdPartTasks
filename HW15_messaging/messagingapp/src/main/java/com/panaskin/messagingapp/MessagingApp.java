package com.panaskin.messagingapp;

import com.panaskin.messagingapp.entity.SumMessage;
import com.panaskin.messagingapp.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessagingApp implements ApplicationRunner {
    @Autowired
    private MessageSender messageSender;

    @Override
    public void run(ApplicationArguments args) {
        for (int i = 0; i < 10; i++) {
            messageSender.sendMessage(new SumMessage(i, 20));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MessagingApp.class, args);
    }
}