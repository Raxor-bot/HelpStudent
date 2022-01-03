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
public class ChatController {
    private static final Logger logger =  LoggerFactory.getLogger(ChatController.class);
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;


@MessageMapping("/chat/{roomId}/sendMessage")
    public void sendMessage(@DestinationVariable long roomId, @Payload ChatMessage chatMessage) {
        logger.info(roomId+" Chat message recieved is "+ chatMessage.getNachricht());

        messagingTemplate.convertAndSend(String.format("/chat-room/%s", roomId), chatMessage);
}

//    @MessageMapping("/chat/{roomId}/addUser")
//    public void addUser(@DestinationVariable long roomId, @Payload ChatMessage chatMessage,
//                        SimpMessageHeaderAccessor headerAccessor) {
//        String currentRoomId = (String) headerAccessor.getSessionAttributes().put("room_id", roomId);
//        if (currentRoomId != null) {
//
//
//
//
//
//
////            leaveMessage.setSender(chatMessage.getSender());
//            messagingTemplate.convertAndSend(String.format("/chat-room/%s", currentRoomId), leaveMessage);
//        }
//        headerAccessor.getSessionAttributes().put("name", chatMessage.getSender());
//        messagingTemplate.convertAndSend(String.format("/chat-room/%s", roomId), chatMessage);
//    }






}