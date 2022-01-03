package com.example.helpstudent.Controller;

import com.example.helpstudent.Tabellen.Student.ChatMessage;
import com.example.helpstudent.Tabellen.Student.ChatType;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController{

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatRoomService chatRoomService;


@MessageMapping("/chat/{roomId}/sendMessage")
    public void sendMessage(@DestinationVariable long roomId, @Payload ChatMessage chatMessage) {
        logger.info(roomId+" Chat message recieved is "+ chatMessage.getNachricht());

        messagingTemplate.convertAndSend(String.format("/chat-room/%s", roomId), chatMessage);
}

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", "jannik");
        return chatMessage;
    }



}