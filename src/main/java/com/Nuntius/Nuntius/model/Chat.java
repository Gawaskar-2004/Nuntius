package com.Nuntius.Nuntius.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "chat")
public class Chat {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAT_ID")
    private Long chatId;

    @Column(name = "CHAT_NAME")
    private String chatName;

    @Column(name = "IS_GROUP")
    private Boolean isGroup;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

}
