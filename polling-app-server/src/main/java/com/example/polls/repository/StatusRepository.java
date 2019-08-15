package com.example.polls.repository;

import com.example.polls.model.Status;
import com.example.polls.model.StatusState;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by kashua14 on 15/08/19.
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findBystate(StatusState statusState);
}
