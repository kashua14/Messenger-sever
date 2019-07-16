package com.example.polls.model;

import com.example.polls.model.audit.DateAudit;

import java.util.HashSet;
import java.util.Set;

//import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
//import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
//import java.util.HashSet;
//import java.util.Set;

/**
 * Created by kashua14 on 14/07/19.
 */

@Entity
public class Messages extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Long senderId;

    @NotBlank
    private Long recieverId;


    @NotBlank
    @Size(max = 1000)
    private String content;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "messages_user",
            joinColumns = @JoinColumn(name = "messages_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    Set<User> sentMessages;

	public Messages() {
		super();
	}

	public Messages(@NotBlank Long senderId, @NotBlank Long recieverId, @NotBlank @Size(max = 1000) String content) {
		super();
		this.senderId = senderId;
		this.recieverId = recieverId;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
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

	public Set<User> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(Set<User> sentMessages) {
		this.sentMessages = sentMessages;
	}
	
	
}