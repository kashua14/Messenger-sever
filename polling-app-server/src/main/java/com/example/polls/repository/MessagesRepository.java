package com.example.polls.repository;

import com.example.polls.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {

	Optional<Messages> findBySenderId(Long senderId);
	 
    List<Messages> findByIdIn(List<Long> userIds);

    Optional<Messages> findByRecieverId(Long senderId);
    
    boolean existsByCreatedAt(LocalDateTime createdAt);
    
    Boolean existsBySenderId(Long senderId);

    Boolean existsByRecieverId(Long recieverId);
}