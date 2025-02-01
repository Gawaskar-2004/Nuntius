package com.Nuntius.Nuntius.controller;

import com.Nuntius.Nuntius.model.Chat;
import com.Nuntius.Nuntius.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    @GetMapping
    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    @PostMapping
    public Chat createChat(@RequestBody Chat chat) {
        return chatRepository.save(chat);
    }
}
