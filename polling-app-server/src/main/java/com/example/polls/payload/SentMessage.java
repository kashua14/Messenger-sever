package com.example.polls.payload;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

public class SentMessage {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Long sender_id;

    @NotBlank
    private Long reciever_id;

    @NotBlank
    @Size(max = 1000)
    private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSender_id() {
		return sender_id;
	}

	public void setSender_id(Long sender_id) {
		this.sender_id = sender_id;
	}

	public Long getReciever_id() {
		return reciever_id;
	}

	public void setReciever_id(Long reciever_id) {
		this.reciever_id = reciever_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
    
}
