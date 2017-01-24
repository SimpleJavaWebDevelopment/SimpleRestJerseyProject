package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messenger.DatabaseClass;
import org.koushik.javabrains.messenger.exception.DataNotFoundException;
import org.koushik.javabrains.messenger.model.Message;

public class MessageService {
	 private  Map<Long, Message> messages = DatabaseClass.getMessages();
	 
	 

		public MessageService() {
			Message m1 = new Message(1L, "Hello World!", "Koushik"); 
			Message m2 = new Message(2L, "Hello Jersey!", "Koushik"); 
			messages.put(1L, m1);
			messages.put(2L, m2);
		}
//	public List<Message> getAllMessages() {
//		Message m1 = new Message(1L, "Hello World!", "Koushik"); 
//		Message m2 = new Message(1L, "Hello Jersey!", "Koushik"); 
//		List<Message> list = new ArrayList<>();
//		list.add(m1);
//		list.add(m2);
//		return list;
//	}
	

	public List<Message> getAllMessages() {
		return new ArrayList<Message> (	messages.values());
	}
	
	public List<Message> getAllMessagesForanYear(int year) {
		
		ArrayList<Message> messagesForYear = new ArrayList<>();
		Calendar calendar =  Calendar.getInstance();
		
		for ( Message message : messages.values()) {
			calendar.setTime(message.getCreated());
			if(calendar.get(Calendar.YEAR) == year  ) {
				messagesForYear.add(message);
			}
			
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> messagesList = new  ArrayList<Message> (	messages.values());
		
		if(start + size >= messagesList.size()  ) {
			return messagesList;
		} else {
			return messagesList.subList(start, size);
		}
		
	}

	public Message getMessage(long messageId) {
		 Message message = messages.get(messageId);
		 if( null == message) {
			 throw new DataNotFoundException("Message with id " + messageId + " Not Found");
		 }
		 return message;
	}
	

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long messageId) {
		return messages.remove(messageId);
	}
	
	
}
