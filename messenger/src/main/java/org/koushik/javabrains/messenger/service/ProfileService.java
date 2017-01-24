package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messenger.DatabaseClass;
import org.koushik.javabrains.messenger.model.Profile;

public class ProfileService {
	 private  Map<String, Profile> profiles = DatabaseClass.getProfiles();
	 

		public ProfileService() {
			Profile p1 = new Profile(1L, "userId1", "FirstName1", "LastName1"); 
			Profile p2 = new Profile(2L, "userId2", "FirstName2", "LastName2"); 
			
			profiles.put(p1.getProfileName(), p1);
			profiles.put(p2.getProfileName(), p2);
		}

	

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile> (	profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	
}
