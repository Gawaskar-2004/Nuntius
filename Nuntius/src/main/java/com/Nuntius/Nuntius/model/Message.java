package com.Nuntius.Nuntius.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    private String messageId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CHAT_ID")
    private Chat chat_id;  // Kept as chat_id

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user_id;  // Kept as user_id

    private String content;
    private LocalDateTime sendAt;  // New field for sending time
    private boolean isRead;  // New field to track if the message has been read

    public Message() {}

    // Getters and Setters
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Chat getChat_id() {
        return chat_id;  // Getter for chat_id
    }

    public void setChat_id(Chat chat_id) {
        this.chat_id = chat_id;  // Setter for chat_id
    }

    public User getUser_id() {
        return user_id;  // Getter for user_id
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;  // Setter for user_id
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getSendAt() {
        return sendAt;
    }

    public void setSendAt(LocalDateTime sendAt) {
        this.sendAt = sendAt;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }
}
