//package com.Nuntius.Nuntius.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//public class Message {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String messageId;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "CHAT_ID")
//    private Chat chat_id;  // Kept as chat_id
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "USER_ID")
//    private User user_id;  // Kept as user_id
//
//    private String content;
//    private LocalDateTime sendAt;  // New field for sending time
//    private boolean isRead;  // New field to track if the message has been read
//
//    public Message() {}
//
//    // Getters and Setters
//    public String getMessageId() {
//        return messageId;
//    }
//
//    public void setMessageId(String messageId) {
//        this.messageId = messageId;
//    }
//
//    public Chat getChat_id() {
//        return chat_id;  // Getter for chat_id
//    }
//
//    public void setChat_id(Chat chat_id) {
//        this.chat_id = chat_id;  // Setter for chat_id
//    }
//
//    public User getUser_id() {
//        return user_id;  // Getter for user_id
//    }
//
//    public void setUser_id(User user_id) {
//        this.user_id = user_id;  // Setter for user_id
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public LocalDateTime getSendAt() {
//        return sendAt;
//    }
//
//    public void setSendAt(LocalDateTime sendAt) {
//        this.sendAt = sendAt;
//    }
//
//    public boolean isRead() {
//        return isRead;
//    }
//
//    public void setRead(boolean isRead) {
//        this.isRead = isRead;
//    }
//}
//package com.Nuntius.Nuntius.model;

//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//public class Message {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "MESSAGE_ID")
//    private Long messageId; // Changed to Long for auto-increment ID
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "CHAT_ID")
//    private Chat chat_id;  // Kept as chat_id
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "USER_ID")
//    private User user_id;  // Kept as user_id
//
//    private String content;
//    private LocalDateTime sendAt;  // Field for sending time
//    private boolean isRead;  // Field to track if the message has been read
//
//    public Message() {}
//
//    // Getters and Setters
//    public Long getMessageId() {
//        return messageId;  // Long type for messageId
//    }
//
//    public void setMessageId(Long messageId) {
//        this.messageId = messageId;
//    }
//
//    public Chat getChat_id() {
//        return chat_id;  // Getter for chat_id
//    }
//
//    public void setChat_id(Chat chat_id) {
//        this.chat_id = chat_id;  // Setter for chat_id
//    }
//
//    public User getUser_id() {
//        return user_id;  // Getter for user_id
//    }
//
//    public void setUser_id(User user_id) {
//        this.user_id = user_id;  // Setter for user_id
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public LocalDateTime getSendAt() {
//        return sendAt;
//    }
//
//    public void setSendAt(LocalDateTime sendAt) {
//        this.sendAt = sendAt;
//    }
//
//    public boolean isRead() {
//        return isRead;
//    }
//
//    public void setRead(boolean isRead) {
//        this.isRead = isRead;
//    }
//}
package com.Nuntius.Nuntius.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private int messageId;  // Use camelCase for consistency

    @ManyToOne
    @JoinColumn(name = "SENDER_ID")  // Foreign key for sender (User)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "RECEIVER_ID")  // Foreign key for receiver (User)
    private User receiver;

    @ManyToOne
    @JoinColumn(name = "CHAT_ID")  // Foreign key for chat
    private Chat chat;  // Change field name from `chat_id` to `chat`

    private String content;
    private LocalDateTime sendAt;
    private boolean isRead;

    // Default constructor
    public Message() {}

    // Getters and Setters
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
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
