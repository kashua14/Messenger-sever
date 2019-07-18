package com.example.polls.payload;

import javax.validation.constraints.*;

/**
 * Created by kashua14 on 18/07/19.
 */

public class SentMessage {
	
    private Long id;

    private Long senderId;

    private Long recieverId;

    @NotBlank
    @Size(max = 1000)
    private String content;

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

	
	
    
}
