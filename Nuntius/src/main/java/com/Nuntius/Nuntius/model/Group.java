package com.Nuntius.Nuntius.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "group.")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID")
    private int  group_id;

    @Column(name = "GROUP_NAME")
    private String group_name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CREATED_BY")
    private User created_by;

    @Column(name = "CREATED_AT")
    private LocalDateTime created_at;

    public int getGroupId() {
        return group_id;
    }

    public void setGroupId(int group_id) {
        this.group_id = group_id;
    }

    public String getGroupName() {
        return group_name;
    }

    public void setGroupName(String groupName) {
        this.group_name = groupName;
    }

    public User getCreatedBy() {
        return created_by;
    }

    public void setCreatedBy(User createdBy) {
        this.created_by = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.created_at = createdAt;
    }
}
