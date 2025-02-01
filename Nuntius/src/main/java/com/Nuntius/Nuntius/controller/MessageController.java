package com.Nuntius.Nuntius.controller;

import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
import com.Nuntius.Nuntius.model.Message;
import com.Nuntius.Nuntius.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Message")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    // Get all messages
    @GetMapping
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    // Create a new message
    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageRepository.save(message);
    }

    // Get message by ID
    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable String id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found with id: " + id));
        return ResponseEntity.ok(message);
    }
}
