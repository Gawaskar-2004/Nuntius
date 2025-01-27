package com.Nuntius.Nuntius.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="chat")
public class Chat {
    @Id
    @Column(name="CHAT_ID")
    private String chat_id;
    @Column(name="CHAT_NAME")
    private String chat_name;
    @Column(name="IS_GROUP")
    private Boolean is_group;
    @Column(name="CREATED_AT")
    private LocalDateTime created_at;

}
