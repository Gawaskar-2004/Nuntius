package com.Nuntius.Nuntius.Service;

import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
import com.Nuntius.Nuntius.model.Message;
import com.Nuntius.Nuntius.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // Get all messages
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    // Create a new message
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }


}

