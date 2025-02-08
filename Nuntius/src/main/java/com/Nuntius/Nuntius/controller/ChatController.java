////package com.Nuntius.Nuntius.controller;
////
////import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
////import com.Nuntius.Nuntius.model.Chat;
////import com.Nuntius.Nuntius.repository.ChatRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////
////@RestController
////@RequestMapping("/api/v1/chats")
////public class ChatController {
////
////    @Autowired
////    private ChatRepository chatRepository;
////
////    // Get all chats
////    @GetMapping
////    public List<Chat> getAllChats() {
////        return chatRepository.findAll();
////    }
////
////    // Create a new chat
////    @PostMapping
////    public Chat createChat(@RequestBody Chat chat) {
////        return chatRepository.save(chat);
////    }
////
////    // Get a chat by its ID
////    @GetMapping("/{chat_id}")
////    public ResponseEntity<Chat> getChatById(@PathVariable String chat_id) {
////        Chat chat = chatRepository.findById(chat_id)
////                .orElseThrow(() -> new ResourceNotFoundException("Chat not found with id: " + chat_id));
////        return ResponseEntity.ok(chat);
////    }
////}
//package com.Nuntius.Nuntius.controller;
//
//import com.Nuntius.Nuntius.model.Chat;
//import com.Nuntius.Nuntius.repository.ChatRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/api/v1/chat")
//public class ChatController {
//
//    @Autowired
//    private ChatRepository chatRepository;
//
//    @GetMapping
//    public List<Chat> getAllChats() {
//        return chatRepository.findAll();
//    }
//
//    @PostMapping
//    public Chat createChat(@RequestBody Chat chat) {
//        return chatRepository.save(chat);
//    }
//}
package com.Nuntius.Nuntius.controller;

import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
import com.Nuntius.Nuntius.model.Chat;
import com.Nuntius.Nuntius.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/chats")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    // Get all chats
    @GetMapping
    public ResponseEntity<List<Chat>> getAllChats() {
        List<Chat> chats = chatRepository.findAll();
        return ResponseEntity.ok(chats);
    }

    // Create a new chat
    @PostMapping
    public ResponseEntity<Chat> createChat(@RequestBody Chat chat) {
        Chat newChat = chatRepository.save(chat);
        return ResponseEntity.ok(newChat);
    }

    // Get chat by ID
    @GetMapping("/{chat_id}")
    public ResponseEntity<Chat> getChatById(@PathVariable String chat_id) {
        Chat chat = chatRepository.findById(chat_id)
                .orElseThrow(() -> new ResourceNotFoundException("Chat not found with id: " + chat_id));
        return ResponseEntity.ok(chat);
    }
}
