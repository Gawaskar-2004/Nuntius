package com.Nuntius.Nuntius.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String notification_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MESSAGE_ID")
    private Message message_id;

    private String type;
    private boolean isSeen;
    private LocalDateTime notifiedAt;

    public Notification() {}

    // Getters and Setters
    public String getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(String notification_id) {
        this.notification_id = notification_id;
    }

    public User getUser_id() {  // Renamed to getUser_id()
        return user_id;
    }

    public void setUser_id(User user_id) {  // Renamed to setUser_id()
        this.user_id = user_id;
    }

    public Message getMessage_id() {  // Renamed to getMessage_id()
        return message_id;
    }

    public void setMessage_id(Message message_id) {
        this.message_id = message_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean isSeen) {
        this.isSeen = isSeen;
    }

    public LocalDateTime getNotifiedAt() {
        return notifiedAt;
    }

    public void setNotifiedAt(LocalDateTime notifiedAt) {
        this.notifiedAt = notifiedAt;
    }
}
