package com.Nuntius.Nuntius.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "group.")
public class group {
    @Id
    @Column(name = "GROUP_ID")
    private String group_id;

    @Column(name = "GROUP_NAME")
    private String group_name;

    @Column(name = "CREATED_BY")
    private String created_by;
    @ManyToOne
    @JoinColumn(name = "CREATED_BY", referencedColumnName = "USER_ID")
    private LocalDateTime created_at;


}
