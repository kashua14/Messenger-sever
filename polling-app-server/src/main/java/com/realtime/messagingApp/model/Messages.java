package com.realtime.messagingApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.realtime.messagingApp.model.audit.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by kashua14 on 14/07/19.
 */

@Entity
public class Messages extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long recieverId;
    
    @NotNull
    private Long senderId;

    @NotBlank
    @Size(max = 1000)
    private String content;

//	@ManyToOne
//    @JoinColumn(name="user_id", nullable=false)
//    private User user;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "User_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private User user;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = true)
//    private User user;
	
//  Constructors
	public Messages() {}

	public Messages(Long recieverId, String content, Long senderId) {
		super();
		this.recieverId = recieverId;
		this.content = content;
		this.senderId = senderId;
	}

//  getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRecieverId() {
		return recieverId;
	}

	public void setRecieverId(Long recieverId) {
		this.recieverId = recieverId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}
	
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
	
}