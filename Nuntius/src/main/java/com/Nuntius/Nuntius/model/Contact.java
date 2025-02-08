package com.Nuntius.Nuntius.model;//package com.Nuntius.Nuntius.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "contact")
//public class Contact {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "CONTACT_ID")
//    private int contactId;
//
//    @ManyToOne
//    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
//    private User user;  // User who added the contact
//
//    @ManyToOne
//    @JoinColumn(name = "CONTACTUSERID", referencedColumnName = "USERID")
//    private User contactUserId;  // The contact user being added
//
//    @Column(name = "ADDED_AT")
//    private LocalDateTime addedAt;
//
//    // Getters and setters
//    public int getContactId() {
//        return contactId;
//    }
//
//    public void setContactId(int contactId) {
//        this.contactId = contactId;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public User getContactUserId() {
//        return contactUserId;
//    }
//
//    public void setContactUserId(User contactUserId) {
//        this.contactUserId = contactUserId;
//    }
//
//    public LocalDateTime getAddedAt() {
//        return addedAt;
//    }
//
//    public void setAddedAt(LocalDateTime addedAt) {
//        this.addedAt = addedAt;
//    }
//
//
//}
//package com.Nuntius.Nuntius.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "contact")
//public class Contact {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "CONTACT_ID")
//    private int contactId;  // Changed from int to Long
//
//    @ManyToOne
//    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
//    private User user;  // The user who added the contact
//
//    @ManyToOne
//    @JoinColumn(name = "CONTACTUSERID", referencedColumnName = "USERID")
//    private User contactUser;  // The contact being added
//
//    @Column(name = "ADDED_AT")
//    private LocalDateTime addedAt;
//
//    // Getters and Setters
//    public int getContactId() {
//        return contactId;
//    }
//
//    public void setContactId(int contactId) {
//        this.contactId = contactId;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public User getContactUser() {  // Fixed method name
//        return contactUser;
//    }
//
//    public void setContactUser(User contactUser) {  // Fixed method name
//        this.contactUser = contactUser;
//    }
//
//    public LocalDateTime getAddedAt() {
//        return addedAt;
//    }
//
//    public void setAddedAt(LocalDateTime addedAt) {
//        this.addedAt = addedAt;
//    }
//}
//package com.Nuntius.Nuntius.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "contacts")
//public class Contact {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user; // User who owns the contact
//
//    @ManyToOne
//    @JoinColumn(name = "contact_user_id", nullable = false)
//    private User contactUser; // Contact being added
//
//    private String name;
//    private String phone_no;
//
//    private LocalDateTime addedAt;
//
//    // Constructors
//    public Contact() {
//        this.addedAt = LocalDateTime.now();
//    }
//
//    public Contact(User user, User contactUser, String name, String phone_no) {
//        this.user = user;
//        this.contactUser = contactUser;
//        this.name = name;
//        this.phone_no = phone_no;
//        this.addedAt = LocalDateTime.now();
//    }
//
//    // Getters and Setters
//    public int getId() { return id; }
//    public void setId(int id) { this.id = id; }
//
//    public User getUser() { return user; }
//    public void setUser(User user) { this.user = user; }
//
//    public User getContactUser() { return contactUser; }
//    public void setContactUser(User contactUser) { this.contactUser = contactUser; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public String getPhone_no() { return phone_no; }
//    public void setPhone_no(String phone_no) { this.phone_no = phone_no; }
//
//    public LocalDateTime getAddedAt() { return addedAt; }
//    public void setAddedAt(LocalDateTime addedAt) { this.addedAt = addedAt; }
//}
//package com.Nuntius.Nuntius.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "contacts")
//public class Contact {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user; // The user who is adding the contact
//
//    @ManyToOne
//    @JoinColumn(name = "contact_user_id", nullable = false)
//    private User contactUser; // The person being added as a contact
//
//    private String name;
//    private long  phoneNo;
//
//    private LocalDateTime addedAt = LocalDateTime.now();
//
//    // Constructors
//    public Contact() {}
//
//    public Contact(User user, User contactUser, String name, long phoneNo) {
//        this.user = user;
//        this.contactUser = contactUser;
//        this.name = name;
//        this.phoneNo = phoneNo;
//        this.addedAt = LocalDateTime.now();
//    }
//
//    // Getters and Setters
//    public int getId() { return id; }
//    public User getUser() { return user; }
//    public User getContactUser() { return contactUser; }
//    public String getName() { return name; }
//    public long getPhoneNo() { return phoneNo; }
//    public LocalDateTime getAddedAt() { return addedAt; }
//}
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Table(name="contact")
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // The user who is adding the contact

    @ManyToOne
    @JoinColumn(name = "contact_user_id", nullable = false)
    private User contactUser; // The person being added as a contact

    private String name;
    private long phoneNo;

    private LocalDateTime addedAt = LocalDateTime.now();

    // ✅ GETTERS AND SETTERS (Ensure these exist)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }  // ✅ This must exist

    public User getContactUser() { return contactUser; }
    public void setContactUser(User contactUser) { this.contactUser = contactUser; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public long getPhoneNo() { return phoneNo; }
    public void setPhoneNo(long phoneNo) { this.phoneNo = phoneNo; }

    public LocalDateTime getAddedAt() { return addedAt; }
    public void setAddedAt(LocalDateTime addedAt) { this.addedAt = addedAt; }
}
