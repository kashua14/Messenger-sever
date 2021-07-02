package com.realtime.messagingApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realtime.messagingApp.model.Status;
import com.realtime.messagingApp.model.StatusState;

/**
 * Created by kashua14 on 15/08/19.
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findBystate(StatusState statusState);
}
