package com.Nuntius.Nuntius.repository;

import com.Nuntius.Nuntius.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, String> {
    // You can define custom query methods here if needed
}
