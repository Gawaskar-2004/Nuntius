package com.Nuntius.Nuntius.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "group.")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID")
    private String group_id;

    @Column(name = "GROUP_NAME")
    private String group_name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CREATED_BY")
    private User created_by;

    @Column(name="CREATED_AT")
    private LocalDateTime created_at;


}
