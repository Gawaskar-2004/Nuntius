package com.Nuntius.Nuntius.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "encrypt")
public class Encryption {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENCRYPTION_ID")
    private Long encryptionId;

    @ManyToOne
    @JoinColumn(name = "CHAT_ID", referencedColumnName = "CHAT_ID")
    private Chat chat;

    @Column(name = "KEY")
    private String key;

    @Column(name = "ALGORITHM")
    private String algorithm;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

}
