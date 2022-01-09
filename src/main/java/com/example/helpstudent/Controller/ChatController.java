package com.example.helpstudent.Controller;

import com.example.helpstudent.Tabellen.ChatMessage;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    private static final Logger logger =  LoggerFactory.getLogger(ChatController.class);
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;


@MessageMapping("/chat/{roomId}/sendMessage")
    public void sendMessage(@DestinationVariable long roomId, @Payload ChatMessage chatMessage) {
        messagingTemplate.convertAndSend(String.format("/chat-room/%s", roomId), chatMessage);
}

}