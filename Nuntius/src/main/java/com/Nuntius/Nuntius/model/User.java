//package com.Nuntius.Nuntius.model;
//
//import jakarta.persistence.*;
//import org.hibernate.annotations.GenericGenerator;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "user")
//public class User {
//
//   @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    private int user_id;
//
//    @Column(name = "NAME")
//    private String name;
//
//    @Column(name = "EMAIL")
//    private String email;
//
//    @Column(name = "PHONE_NO")
//    private long phone_no;
//
//
//    @Column(name = "CREATED_AT")
//    private LocalDateTime created_at;
//
//    @PrePersist
//    protected void onCreate() {
//        this.created_at = LocalDateTime.now();
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Column(name="PASSWORD")
//    private String password;
//
//
//    public int getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(int user_id) {
//        this.user_id = user_id;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//
//    public long getPhone_no() {
//        return phone_no;
//    }
//
//    public void setPhone_no(long phone_no) {
//        this.phone_no = phone_no;
//    }
//
//
//    public LocalDateTime getCreated_at() {
//        return created_at;
//    }
//
//    public void setCreated_at(LocalDateTime created_at) {
//        this.created_at = created_at;
//    }
//
//
//

package com.Nuntius.Nuntius.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;  // Primary key field

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NO")
    private long phoneNo;

    @Column(name = "CREATED_AT")
    private LocalDateTime created_at;



    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
    }

    @Column(name="PASSWORD")
    private String password;

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Alternative getter method for user_id if needed as getId()
    public int getId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
