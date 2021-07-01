package com.realtime.messagingApp.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import com.realtime.messagingApp.model.Messages;
import com.realtime.messagingApp.payload.SentMessage;
import com.realtime.messagingApp.repository.MessagesRepository;
import com.realtime.messagingApp.repository.UserRepository;
import com.realtime.messagingApp.security.CurrentUser;
import com.realtime.messagingApp.security.UserPrincipal;
import com.realtime.messagingApp.service.MessageService;

@RestController
@RequestMapping("/api")
public class MessagesController {

	@Autowired
    private MessagesRepository messagesRepository;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(MessagesController.class);
    
    @MessageMapping("/chat.sendMessage")
    @SendTo("/chats/chatHistory/{senderId}/{recieverId}")
    public SentMessage sendMessage(@Payload SentMessage sentMessage) {
        return sentMessage;
    }

    // getting previous chats
    @GetMapping("/chats/chatHistory/{senderId}/{recieverId}")
    public ArrayList<Messages> getChatHistory(@PathVariable Long recieverId, @PathVariable Long senderId) {
		return messageService.getMessages(senderId, recieverId);
    }
    
    @PostMapping("/chats/chatroom")
    public boolean sendMessage(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody SentMessage sentMessage ) {
//		if(userRepository.existsByIdIn(sentMessage.getRecieverId())) {
//			// Save message
			Messages messages = new Messages(sentMessage.getRecieverId(), sentMessage.getContent(), currentUser.getId());
			messagesRepository.save(messages);
			
//			@PostUpdate
//			Consumer sentMsg = new Consumer(messages);
			return true;
//        }
//		return false;
	}
}
