package org.koushik.javabrains.messenger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

//import javax.xml.bind.annotation.XmlRootElement;

//needed to tell jaxb to conversion java obkect to xml 
//@XmlRootElement
public class Message {
	private long id;
	private String message; 
	private Date created; 
	private String author;
	
	private static Map<Long, Comment> comments = new HashMap<>();
	
	public Message() {
		
	}
	
	public Message(long id, String message,  String author) {
		super();
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	// https://javabrains.io/courses/javaee_jaxrs/lessons/Implementing-Subresources

	// Comment list is to be ingoned for xml and json conversion 
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
	

}
