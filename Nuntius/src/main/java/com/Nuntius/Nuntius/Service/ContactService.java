package com.Nuntius.Nuntius.Service;


//package com.Nuntius.Nuntius.Service;
//
//import com.Nuntius.Nuntius.model.Contact;
//import com.Nuntius.Nuntius.model.User;
//import com.Nuntius.Nuntius.repository.ContactRepository;
//import com.Nuntius.Nuntius.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class ContactService {
//
//    @Autowired
//    private ContactRepository contactRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    // Get all contacts
//    public List<Contact> getAllContacts() {
//        return contactRepository.findAll();
//    }
//
//    // Get contacts for a specific user
//    public List<Contact> getContactsByUserId(int userId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        return contactRepository.findByUser(user);
//    }
//
//    // Add a new contact with name and phone number
//    public Contact addContact(int userId, int contactUserId, String name, String phoneNo) {
//        // Fetch user who is adding the contact
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        // Fetch the contact user being added
//        User contactUser = userRepository.findById(contactUserId)
//                .orElseThrow(() -> new RuntimeException("Contact user not found"));
//
//        // Create and save contact
//        Contact contact = new Contact(user, contactUser, name, phoneNo);
//        return contactRepository.save(contact);
//    }
//}
//package com.Nuntius.Nuntius.Service;
//import com.Nuntius.Nuntius.model.Contact;
//import com.Nuntius.Nuntius.model.User;
//import com.Nuntius.Nuntius.repository.ContactRepository;
//import com.Nuntius.Nuntius.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.Optional;
//
//@Service
//public class ContactService {
//
//    @Autowired
//    private ContactRepository contactRepository;
//
//    @Autowired
//    private UserRepository userRepository; // Assuming UserRepository exists
//
//    public Contact addContact(int userId, String name, long phoneNo) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        Optional<User> contactUserOptional = userRepository.findByPhoneNo(phoneNo);
//
//        if (userOptional.isPresent() && contactUserOptional.isPresent()) {
//            Contact contact = new Contact();
//            contact.setUser(userOptional.get());
//            contact.setContactUser(contactUserOptional.get());
//            contact.setName(name);
//            contact.setPhoneNo(phoneNo);
//            return contactRepository.save(contact);
//        } else {
//            throw new RuntimeException("User or contact user not found");
//        }
//    }
//}
import com.Nuntius.Nuntius.model.Contact;
import com.Nuntius.Nuntius.model.User;
import com.Nuntius.Nuntius.repository.ContactRepository;
import com.Nuntius.Nuntius.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    public Contact addContact(int userId, String name, long phoneNo) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<User> contactUserOptional = userRepository.findByPhoneNo(phoneNo);

        if (userOptional.isPresent() && contactUserOptional.isPresent()) {
            Contact contact = new Contact();
            contact.setUser(userOptional.get());  // ✅ Ensure this method exists in Contact.java
            contact.setContactUser(contactUserOptional.get());
            contact.setName(name);
            contact.setPhoneNo(phoneNo);
            return contactRepository.save(contact);
        } else {
            throw new RuntimeException("User or contact user not found");
        }
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public List<Contact> getContactsByUserId(int userId) {
        return contactRepository.findByUserId(userId);
    }

}
