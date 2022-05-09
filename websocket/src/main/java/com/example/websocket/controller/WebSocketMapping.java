package com.example.websocket.controller;

import com.example.websocket.model.CharMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketMapping {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketMapping.class);
    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketMapping(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/ws/chat")
    public void sendRoom(CharMessage chatMessage) {
        logger.info(chatMessage.toString());
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        simpMessagingTemplate.convertAndSend(
                String.format("/receive-endpoint/%s", chatMessage.getRoomId()),
                new CharMessage(chatMessage.getRoomId(), chatMessage.getSender(), chatMessage.getMessage(), time)
        );
    }


}
