package com.example.polls.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.polls.model.Messages;
import com.example.polls.repository.MessagesRepository;

@Service
public class MessageService {
	
	@Autowired
    private MessagesRepository messagesRepository;

	public ArrayList<Messages> getMessages(Long recieverId, Long senderId) {
		ArrayList<Messages> chatHistory = new ArrayList<>();
//		ArrayList<Messages> myChatHistory = new ArrayList<>();
		 for(Messages m: messagesRepository.findAll()) {
			 if(m.getRecieverId().equals(recieverId) && m.getSenderId().equals(senderId)) {
				 chatHistory.add(m);
			 }
			 else if(m.getSenderId().equals(senderId) && m.getRecieverId().equals(recieverId)) {
				 chatHistory.add(m);
			 }
			 else { /* Do nothing*/ ; }
		 }
		 return chatHistory;
	}
	
	
	
}
