//package com.Nuntius.Nuntius.controller;
//
//import com.Nuntius.Nuntius.Service.MessageService;
//import com.Nuntius.Nuntius.model.Message;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/message")
//public class MessageController {
//    @Autowired
//    private MessageService messageService;
//
//    @GetMapping("/{chat_id}")
//    public ResponseEntity<List<Message>> getChatMessages(@PathVariable int chat_id) {
//        return ResponseEntity.ok(messageService.getMessagesByChat(chat_id));
//    }
//
//
//    @PostMapping
//    public ResponseEntity<Message> sendMessage(@RequestBody Map<String, Object> requestBody) {
//        int chat_id = Integer.parseInt(requestBody.get("chat_id").toString());
//        int sender_id = 1; // Assume logged-in user (Replace with actual authentication logic)
//        String content = requestBody.get("content").toString();
//
//        Message message = messageService.sendMessage(chat_id, sender_id, content);
//        return ResponseEntity.ok(message);
//    }
//
//}
