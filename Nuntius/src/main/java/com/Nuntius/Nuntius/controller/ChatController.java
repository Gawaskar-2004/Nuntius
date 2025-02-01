package com.Nuntius.Nuntius.controller;

import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
import com.Nuntius.Nuntius.model.Chat;
import com.Nuntius.Nuntius.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chats")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    // Get all chats
    @GetMapping
    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    // Create a new chat
    @PostMapping
    public Chat createChat(@RequestBody Chat chat) {
        return chatRepository.save(chat);
    }

    // Get a chat by its ID
    @GetMapping("/{chat_id}")
    public ResponseEntity<Chat> getChatById(@PathVariable String chat_id) {
        Chat chat = chatRepository.findById(chat_id)
                .orElseThrow(() -> new ResourceNotFoundException("Chat not found with id: " + chat_id));
        return ResponseEntity.ok(chat);
    }

    // Update a chat by its ID
    @PutMapping("/{chat_id}")
    public ResponseEntity<Chat> updateChat(@PathVariable String chat_id, @RequestBody Chat chatDetails) {
        Chat chat = chatRepository.findById(chat_id)
                .orElseThrow(() -> new ResourceNotFoundException("Chat not found with id: " + chat_id));

        chat.setChat_name(chatDetails.getChat_name());
        chat.setIs_group(chatDetails.getIs_group());
        chat.setCreated_at(chatDetails.getCreated_at());

        Chat updatedChat = chatRepository.save(chat);
        return ResponseEntity.ok(updatedChat);
    }

    // Delete a chat by its ID
    @DeleteMapping("/{chat_id}")
    public ResponseEntity<Void> deleteChat(@PathVariable String chat_id) {
        Chat chat = chatRepository.findById(chat_id)
                .orElseThrow(() -> new ResourceNotFoundException("Chat not found with id: " + chat_id));

        chatRepository.delete(chat);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
