package com.mymessenger.repo;

import com.mymessenger.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Aurimas
 * @created 2023-04-03
 */
public interface MessageRepository extends JpaRepository <Message, Long> {
    List<Message> findByUserId(Long userId);
}
