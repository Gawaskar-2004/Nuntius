package com.Nuntius.Nuntius.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CHAT_ID")
    private int chat_id;
    @Column(name="CHAT_NAME")
    private String chat_name;
    @Column(name="IS_GROUP")
    private Boolean is_group;
    @Column(name="CREATED_AT")
    private LocalDateTime created_at;

    public int getChat_id() {
        return chat_id;
    }

    public void setChatId(int chat_id) {
        this.chat_id = chat_id;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public Boolean getIs_group() {
        return is_group;
    }

    public void setIs_group(Boolean is_group) {
        this.is_group = is_group;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public int getId() {
        return chat_id;
    }
}
