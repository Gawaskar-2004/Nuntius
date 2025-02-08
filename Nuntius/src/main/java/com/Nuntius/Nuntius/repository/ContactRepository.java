//package com.Nuntius.Nuntius.repository;
//
//import com.Nuntius.Nuntius.model.Contact;
//import com.Nuntius.Nuntius.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ContactRepository extends JpaRepository<Contact, User> {
//    List<Contact> findByUser(User user);
//}
package com.Nuntius.Nuntius.repository;

import com.Nuntius.Nuntius.model.Contact;
import com.Nuntius.Nuntius.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findByUserId(int userId);  // Changed from User to Long (ID)

}
