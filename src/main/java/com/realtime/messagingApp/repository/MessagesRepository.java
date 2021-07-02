package com.realtime.messagingApp.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realtime.messagingApp.model.Messages;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {

	Optional<Messages> findBySenderId(Long senderId);
	 
    List<Messages> findByIdIn(List<Long> userIds);

    Optional<Messages> findByRecieverId(Long recieverId);
//    
//    Optional<Messages> findByUserId(Long SenderId);
    
//    Optional<Messages> findByIdAndUserId(Long id, Long UserId);
    
    Boolean existsByRecieverId(Long recieverId);
    
    boolean existsByCreatedAt(LocalDateTime createdAt);
    
    Boolean existsBySenderId(Long senderId);

}