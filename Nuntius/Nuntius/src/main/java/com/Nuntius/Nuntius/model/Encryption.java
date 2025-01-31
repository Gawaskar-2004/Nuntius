package com.Nuntius.Nuntius.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "encryption")
public class Encryption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENCRYPTION_ID")
    private Long encryptionId; // Changed to Long for auto_increment

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ENCRYPTED_CHAT_ID", referencedColumnName = "CHAT_ID")
    private Chat chat;  // This represents the foreign key relationship to Chat

    @Column(name = "ENCRYPTIONKEY")
    private String encryptionKey;  // Renamed to avoid conflict with SQL keyword

    @Column(name = "ALGORITHM")
    private String algorithm;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    // Getters and setters
    public Long getEncryptionId() {
        return encryptionId;
    }

    public void setEncryptionId(Long encryptionId) {
        this.encryptionId = encryptionId;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
