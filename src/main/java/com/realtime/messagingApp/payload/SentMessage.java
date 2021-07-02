package com.realtime.messagingApp.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import com.realtime.messagingApp.model.User;

/**
 * Created by kashua14 on 18/07/19.
 */

public class SentMessage {

	@NotNull
    private Long recieverId;
	
	@NotNull
    private Long senderId;

    @NotBlank
    @Size(max = 1000)
    private String content;

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

	
	
    
}
