package com.example.websocketdemo.controller;

import com.example.websocketdemo.config.Authentication;
import com.example.websocketdemo.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;

import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 所有从客户端发来的消息，目的地以/app开头的都要发送到对应@MessageMapping中
     * 比如 客户端目的地是 /app/chat.sendMessage 那么就会发送到该方法进行处理。
     *
     * @param chatMessage
     * @return
     */
    @MessageMapping("/chat.sendMessage")
    @SendToUser("/queue/reply")
    public ChatMessage handleMessage(@Payload ChatMessage chatMessage, Principal principal) {
        ChatMessage message = new ChatMessage();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        message.setSender("小智");
        message.setContent("我了解了");
        message.setType(ChatMessage.MessageType.CHAT);
        System.out.println(principal.getName());
        messagingTemplate.convertAndSendToUser(message.getSender(), "/queue/reply", message);
        return message;
    }
}
