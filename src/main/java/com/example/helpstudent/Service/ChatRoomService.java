package com.example.helpstudent.Service;

import com.example.helpstudent.Repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService{

    private final ChatRoomRepository repo;

    public ChatRoomService(ChatRoomRepository repo) {
        this.repo = repo;
    }
}
