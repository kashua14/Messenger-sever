package com.realtime.messagingApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realtime.messagingApp.model.User;

/**
 * Created by Joshua on 02/08/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);
    
    Optional<User> findByStatus(String status);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
//    boolean existsByIdIn(Long id);
}
