package org.koushik.javabrains.messenger;

import java.util.HashMap;
import java.util.Map;

import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.model.Profile;

//2.7 Building Service Stubs
// In this tutorial, we'll build and stub business and data services that we can call from the Message resource class.
// https://javabrains.io/courses/javaee_jaxrs/lessons/Building-Service-Stubs

public class DatabaseClass {
//not thread safe , not for production	
	private static Map<Long, Message> messages = new HashMap<>(); 
	
	//2.12 Implementing ProfileResource 
	// change to String to look by profile Name
	private static Map<String, Profile> Profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return Profiles;
	}
	
}
