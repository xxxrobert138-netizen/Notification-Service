package com.example.Notification.Service.controller;

import com.example.Notification.Service.util.ConsoleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/chat")
    public String getChatPage() {
        ConsoleHelper.printInformation("User enter to chat", ConsoleHelper.MessageType.INFO);
        return "chat";
    }

    @MessageMapping("/send")
    public void respondOnMessage(String message) {
        System.out.println(String.format("Message: %s", message));
        simpMessagingTemplate.convertAndSend("/topic/messages", message);
    }

}
