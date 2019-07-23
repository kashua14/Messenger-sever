package com.example.polls.payload;

import javax.validation.constraints.*;

//import com.example.polls.model.User;

/**
 * Created by kashua14 on 18/07/19.
 */

public class SentMessage {

	@NotNull
    private Long recieverId;

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

	
	
    
}
