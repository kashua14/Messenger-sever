package com.realtime.messagingApp.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;

/**
 * Created by kashua14 on 15/08/19.
 */
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private StatusState state;

    public Status() {

    }

    public Status(StatusState state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusState getName() {
        return state;
    }

    public void setName(StatusState state) {
        this.state = state;
    }

}

