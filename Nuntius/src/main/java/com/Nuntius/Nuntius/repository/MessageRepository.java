package com.Nuntius.Nuntius.repository;

import com.Nuntius.Nuntius.model.Chat;
import com.Nuntius.Nuntius.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByChat(Chat chat); // Use the correct field name
}

