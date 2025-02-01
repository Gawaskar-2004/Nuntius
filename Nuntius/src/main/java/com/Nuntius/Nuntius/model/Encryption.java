package com.Nuntius.Nuntius.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "encryption")
public class Encryption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENCRYPTION_ID")
    private Long encryption_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="CHAT_ID")
    private Chat chat_id;

    @Column(name = "ENCRYPTIONKEY")
    private String encryptionKey;

    @Column(name = "ALGORITHM")
    private String algorithm;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;


    public Long getEncryptionId() {
        return encryption_id;
    }

    public void setEncryptionId(Long encryption_id) {
        this.encryption_id = encryption_id;
    }

    public Chat getChat() {
        return chat_id;
    }

    public void setChat(Chat chat_id) {
        this.chat_id = chat_id;
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
