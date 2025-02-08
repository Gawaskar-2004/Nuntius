package com.Nuntius.Nuntius.controller;//package com.Nuntius.Nuntius.controller;
//
//import com.Nuntius.Nuntius.model.Contact;
//import com.Nuntius.Nuntius.repository.ContactRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/contact")
//public class ContactController {
//
//    @Autowired
//    private ContactRepository contactRepository;
//    private Object contactService;
//
//    @GetMapping
//    public List<Contact> getAllContacts() {
//        return contactRepository.findAll();
//    }
//
//    @PostMapping
//    public Contact createContact(@RequestBody Contact contact) {
//        return contactRepository.save(contact);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<Contact> addContact(@RequestParam int userId, @RequestParam int contactUserId) {
//        Contact savedContact = contactService.addContact(userId, contactUserId);
//        return ResponseEntity.ok(savedContact);
//    }
//
//
//
//
//}
//package com.Nuntius.Nuntius.controller;
//
//import com.Nuntius.Nuntius.Service.ContactService;
//import com.Nuntius.Nuntius.model.Contact;
//import com.Nuntius.Nuntius.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/contact")
//public class ContactController {
//
//    @Autowired
//    private ContactService contactService;
//
//    // Get all contacts
//    @GetMapping
//    public List<Contact> getAllContacts() {
//        return contactService.getAllContacts();
//    }
//
//    // Get contacts by user ID
//    @GetMapping("/{userId}")
//    public ResponseEntity<List<Contact>> getUserContacts(@PathVariable int userId) {
//        List<Contact> contacts = contactService.getContactsByUserId(userId);
//        return ResponseEntity.ok(contacts);
//    }
//
//    // Add a new contact
//    @PostMapping("/add")
//    public ResponseEntity<Contact> addContact(@RequestParam int userId, @RequestParam User contactUser) {
//        Contact savedContact = contactService.addContact(userId, contactUser);
//        return ResponseEntity.ok(savedContact);
//    }
//}
//new code
//package com.Nuntius.Nuntius.controller;
//
//import com.Nuntius.Nuntius.Service.ContactService;
//import com.Nuntius.Nuntius.model.Contact;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@CrossOrigin(origins = "http://localhost:3001")
//@RestController
//@RequestMapping("/api/v1/contact")
//public class ContactController {
//
//    @Autowired
//    private ContactService contactService;
//
//    // Get all contacts (for testing/debugging)
//    @GetMapping
//    public List<Contact> getAllContacts() {
//        return contactService.getAllContacts();
//    }
//
//    // Get contacts for a specific user
//    @GetMapping("/{userId}")
//    public ResponseEntity<List<Contact>> getUserContacts(@PathVariable int userId) {
//        List<Contact> contacts = contactService.getContactsByUserId(userId);
//        return ResponseEntity.ok(contacts);
//    }
//
//    // Add a new contact
////    @PostMapping("/add")
////    public ResponseEntity<Contact> addContact(@RequestParam int userId, @RequestParam int contactUserId) {
////        Contact savedContact = contactService.addContact(userId, contactUserId);
////        return ResponseEntity.ok(savedContact);
////    }
//    @PostMapping("/add")
//    public ResponseEntity<?> addContact(@RequestBody ContactRequest request) {
//        if (request.getUserId() <= 0 || request.getContactUserId() <= 0) {
//            return ResponseEntity.badRequest().body("Invalid user ID or contact ID");
//        }
//
//        try {
//            Contact savedContact = contactService.addContact(request.getUserId(), request.getContactUserId());
//            return ResponseEntity.ok(savedContact);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
//        }
//    }
//
//
//    class ContactRequest {
//        private int userId;
//        private int contactUserId;
//
//        // Getters and Setters
//        public int getUserId() {
//            return userId;
//        }
//
//        public void setUserId(int userId) {
//            this.userId = userId;
//        }
//
//        public int getContactUserId() {
//            return contactUserId;
//        }
//
//        public void setContactUserId(int contactUserId) {
//            this.contactUserId = contactUserId;
//        }
//    }
//
//}
//package com.Nuntius.Nuntius.controller;
//
//import com.Nuntius.Nuntius.Service.ContactService;
//import com.Nuntius.Nuntius.model.Contact;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:3001")
//@RestController
//@RequestMapping("/api/v1/contact")
//public class ContactController {
//
//    @Autowired
//    private ContactService contactService;
//
//    // Get all contacts (for testing/debugging)
//    @GetMapping
//    public List<Contact> getAllContacts() {
//        return contactService.getAllContacts();
//    }
//
//    // Get contacts for a specific user
//    @GetMapping("/{userId}")
//    public ResponseEntity<List<Contact>> getUserContacts(@PathVariable int userId) {
//        List<Contact> contacts = contactService.getContactsByUserId(userId);
//        return ResponseEntity.ok(contacts);
//    }
//
//    // Add a new contact
//    @PostMapping("/add")
//    public ResponseEntity<Contact> addContact(@RequestBody ContactRequest request) {
//        Contact savedContact = contactService.addContact(
//                request.getUserId(), request.getContactUserId(), request.getName(), request.getPhoneNo()
//        );
//        return ResponseEntity.ok(savedContact);
//    }
//
//    // Inner class to handle JSON request
//    static class ContactRequest {
//        private int userId;
//        private int contactUserId;
//        private String name;
//        private String phoneNo;
//
//        // Getters and Setters
//        public int getUserId() { return userId; }
//        public void setUserId(int userId) { this.userId = userId; }
//
//        public int getContactUserId() { return contactUserId; }
//        public void setContactUserId(int contactUserId) { this.contactUserId = contactUserId; }
//
//        public String getName() { return name; }
//        public void setName(String name) { this.name = name; }
//
//        public String getPhoneNo() { return phoneNo; }
//        public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
//    }
//}
//package com.Nuntius.Nuntius.controller;
//
//import com.Nuntius.Nuntius.model.Contact;
//import com.Nuntius.Nuntius.model.User;
//import com.Nuntius.Nuntius.Service.ContactService;
//import com.Nuntius.Nuntius.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:3001")
//@RestController
//@RequestMapping("/api/v1/contact")
//public class ContactController {
//
//    @Autowired
//    private ContactService contactService;
//
//    @Autowired
//    private UserService userService;
//
//    // Get all contacts (for testing/debugging)
//    @GetMapping
//    public List<Contact> getAllContacts() {
//        return contactService.getAllContacts();
//    }
//
//    // Get contacts for a specific user
//    @GetMapping("/{userId}")
//    public ResponseEntity<List<Contact>> getUserContacts(@PathVariable int userId) {
//        List<Contact> contacts = contactService.getContactsByUserId(userId);
//        return ResponseEntity.ok(contacts);
//    }
//
//    // Add a new contact (Frontend only sends name & phoneNo)
//    @PostMapping("/add")
//    public ResponseEntity<Contact> addContact(@RequestBody ContactRequest request) {
//        // Fetch the logged-in user
//        User user = userService.getUserById(request.getUserId());
//
//        // Fetch the selected contact user
//        User contactUser = userService.getUserById(request.getContactUserId());
//
//        // Save contact
//        Contact savedContact = contactService.addContact(user, contactUser, request.getName(), request.getPhoneNo());
//
//        return ResponseEntity.ok(savedContact);
//    }
////    @PostMapping("/add")
////    public ResponseEntity<?> addContact(@RequestBody ContactRequest request) {
////        try {
////            // Fetch users
////            User user = userService.getUserById(request.getUserId());
////            User contactUser = userService.getUserById(request.getContactUserId());
////
////            // Check if users exist
////            if (user == null || contactUser == null) {
////                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User or Contact User not found.");
////            }
////
////            // Save contact
////            Contact savedContact = contactService.addContact(user, contactUser, request.getName(), request.getPhoneNo());
////            return ResponseEntity.ok(savedContact);
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding contact: " + e.getMessage());
////        }
////    }
//// Add a new contact
////    @PostMapping("/add")
////    public ResponseEntity<?> addContact(@RequestBody ContactRequest request) {
////        System.out.println("Received request: " + request); // Debugging log
////
////        if (request.getName() == null || request.getPhoneNo() == null) {
////            return ResponseEntity.badRequest().body("Name and phone number are required.");
////        }
////
////        Contact savedContact = contactService.addContact(
////                request.getUserId(), request.getContactUserId(), request.getName(), request.getPhoneNo()
////        );
////
////        return ResponseEntity.ok(savedContact);
////    }
//
//
//    // Inner class to handle JSON request
//    static class ContactRequest {
//        private int userId;
//        private int contactUserId;
//        private String name;
//        private String phoneNo;
//
//        // Getters and Setters
//        public int getUserId() { return userId; }
//        public void setUserId(int userId) { this.userId = userId; }
//
//        public int getContactUserId() { return contactUserId; }
//        public void setContactUserId(int contactUserId) { this.contactUserId = contactUserId; }
//
//        public String getName() { return name; }
//        public void setName(String name) { this.name = name; }
//
//        public String getPhoneNo() { return phoneNo; }
//        public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
//    }
//}
//package com.Nuntius.Nuntius.controller;
//
//import com.Nuntius.Nuntius.Dto.ContactRequest;
//import com.Nuntius.Nuntius.model.Contact;
//import com.Nuntius.Nuntius.Service.ContactService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin(origins = "http://localhost:3001") // Adjust if needed
//@RestController
//@RequestMapping("/api/v1/contact")
//public class ContactController {
//
//    @Autowired
//    private ContactService contactService;
//
//    @PostMapping("/add")
//    public ResponseEntity<Contact> addContact(@RequestBody ContactRequest request) {
//        Contact savedContact = contactService.addContact(request.getUserId(), request.getContactUserId(), request.getName(), request.getPhoneNo());
//        return ResponseEntity.ok(savedContact);
//    }
//}


//package com.Nuntius.Nuntius.controller;
//
//import com.Nuntius.Nuntius.Service.ContactService;
//import com.Nuntius.Nuntius.model.Contact;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/api/v1/contact")
//public class ContactController {
//
//    @Autowired
//    private ContactService contactService;
//
//    // Get all contacts (for testing/debugging)
//    @GetMapping
//    public List<Contact> getAllContacts() {
//        return contactService.getAllContacts();
//    }
//
//    // Get contacts for a specific user
//    @GetMapping("/{userId}")
//    public ResponseEntity<List<Contact>> getUserContacts(@PathVariable int userId) {
//        List<Contact> contacts = contactService.getContactsByUserId(userId);
//        return ResponseEntity.ok(contacts);
//    }
//
//    // Add a new contact
//    @PostMapping("/add")
//    public ResponseEntity<Contact> addContact(@RequestBody ContactRequest request) {
//        Contact savedContact = contactService.addContact(
//                request.getUserId(), request.getContactUserId(), request.getName(), request.getPhoneNo()
//        );
//        return ResponseEntity.ok(savedContact);
//    }
//
//    // Inner class to handle JSON request
//    static class ContactRequest {
//        private int userId;
//        private int contactUserId;
//        private String name;
//        private String phoneNo;
//
//        // Getters and Setters
//        public int getUserId() { return userId; }
//        public void setUserId(int userId) { this.userId = userId; }
//
//        public int getContactUserId() { return contactUserId; }
//        public void setContactUserId(int contactUserId) { this.contactUserId = contactUserId; }
//
//        public String getName() { return name; }
//        public void setName(String name) { this.name = name; }
//
//        public String getPhoneNo() { return phoneNo; }
//        public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
//    }
//}
import com.Nuntius.Nuntius.Service.ContactService;
import com.Nuntius.Nuntius.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Nuntius.Nuntius.Dto.ContactRequest;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    @Autowired
    private ContactService contactService;
    @GetMapping
    public List<Contact> getAllContacts() {
       return contactService.getAllContacts();
  }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Contact>> getUserContacts(@PathVariable int userId) {
       List<Contact> contacts = contactService.getContactsByUserId(userId);
      return ResponseEntity.ok(contacts);
 }

//    @PostMapping("/add")
//    public ResponseEntity<Contact> addContact(@RequestParam int userId, @RequestParam String name, @RequestParam long phoneNo) {
//        Contact contact = contactService.addContact(userId, name, phoneNo);
//        return ResponseEntity.ok(contact);
//    }


    @PostMapping("/add")
    public ResponseEntity<String> addContact(@RequestBody ContactRequest request) {
        try {
            contactService.addContact(request.getUserId(), request.getName(), request.getPhoneNo());
            return ResponseEntity.ok("Contact added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
