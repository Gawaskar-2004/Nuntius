package com.Nuntius.Nuntius.Service;

import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
import com.Nuntius.Nuntius.model.Chat;
import com.Nuntius.Nuntius.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    // Get all chats
    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    // Create a new chat
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }

    // Get a chat by its ID
    public Chat getChatById(String chatId) {
        return chatRepository.findById(chatId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat not found with id: " + chatId));
    }
}