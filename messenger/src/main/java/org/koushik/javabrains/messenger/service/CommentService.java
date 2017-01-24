package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.koushik.javabrains.messenger.DatabaseClass;
import org.koushik.javabrains.messenger.model.Comment;
import org.koushik.javabrains.messenger.model.ErrorMessage;
import org.koushik.javabrains.messenger.model.Message;

public class CommentService {
	 private  Map<Long, Message> messages = DatabaseClass.getMessages();
	 
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment> (	comments.values());
	}
	
	
	public Comment getComment(long messageId, long commentId) {
		ErrorMessage errorMessage = new ErrorMessage("not found", 404, "Http://Somelink");
		
		Response errResponse =  Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		Message message = messages.get(messageId);
		if(message == null) {
			throw new WebApplicationException(errResponse);
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if( null == comments) {
			//throw new WebApplicationException(Status.NOT_FOUND);
			throw new WebApplicationException(errResponse);

		}
		
		return comments.get(commentId);
	}
	

	public Comment addComment(long messageId,Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(long messageId,Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comment.getId() <= 0){
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();

		return comments.remove(commentId);
	}
	
	
}
