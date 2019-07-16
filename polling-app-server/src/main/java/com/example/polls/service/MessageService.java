package com.example.polls.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.model.Messages;
import com.example.polls.payload.PreviousChat;
import com.example.polls.repository.MessagesRepository;
import com.example.polls.repository.PollRepository;

@Service
public class MessageService {
	
	@Autowired
    private MessagesRepository messagesRepository;

	public ArrayList<Messages> getMessages(Long sender, Long reciever) {
		ArrayList<Messages> chatHistory = new ArrayList<>();
//		ArrayList<Messages> myChatHistory = new ArrayList<>();
		 for(Messages m: messagesRepository.findAll()) {
			 if(m.getRecieverId().equals(reciever) && m.getSenderId().equals(sender)) {
				 chatHistory.add(m);
			 }
			 else if(m.getSenderId().equals(sender) && m.getRecieverId().equals(reciever)) {
				 chatHistory.add(m);
			 }
			 else {
				 // Do nothing
			 }
		 }
		 return chatHistory;
	}
}
