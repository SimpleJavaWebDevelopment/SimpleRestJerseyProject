package org.koushik.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import javax.xml.bind.annotation.XmlRootElement;

import org.koushik.javabrains.messenger.service.ProfileService;
import org.koushik.javabrains.messenger.model.Profile;

@Path("/profiles")
// If all the method use same @Consumes and Produces then we can annotate it at Class level 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getProfiles() {
//		return "Hello World";
//	}
	
	
	ProfileService profileService = new ProfileService();
	@GET
	// 2.4 Creating A Resource
	// In this tutorial, we'll create our first JAX-RS resource that handles a GET request to an API URL.
	// https://javabrains.io/courses/javaee_jaxrs/lessons/Creating-A-Resource
	
	// 2.5 Returning XML Response
	// Let's return some data in XML format from the resource. We'll update the ProfileResource to return a list of Profiles in XML.
	// https://javabrains.io/courses/javaee_jaxrs/lessons/Returning-Xml-Response
	// for application xml annotate model profile.java with @XmlRootElement
	// Jaxb comes along with Java so we don't need any extra configuration
	
	///  @Produces(MediaType.APPLICATION_XML)
	
	//2.9 Returning JSON Response
	// We'll now switch the response format of the APIs from XML to JSON.
	// https://javabrains.io/courses/javaee_jaxrs/lessons/Returning-JSON-Response
	// but for json we need to add the jar i.e jersey-media-moxy to application class path 
	// there is an class profileBodyWrite which does object to json conversion
	/// Moved to class level @Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}
	
	//use path param to get only one Profile
	
	@GET
	@Path("/{profileName}")
	
	public Profile getProfile( @PathParam("profileName")  String name) {
		return profileService.getProfile(name);
	}
	
	//2.10 Implementing POST Method
	// In this tutorial, we'll implement the POST method API to create new instances of Profile resource.
	// https://javabrains.io/courses/javaee_jaxrs/lessons/Implementing-POST-Method
	
	@POST
	//Also include annotation @Consumes 
	/// Moved to class level @Consumes(MediaType.APPLICATION_JSON)
	/// Moved to class level @Produces(MediaType.APPLICATION_JSON)
	// Jersey will use jersey-media-moxy to convert Json to object
	public Profile addProfile(  Profile profile) {
		return profileService.addProfile(profile);
	}
	
	//2.11 Implementing Update and Delete
	// We'll now implement update and delete APIs with the PUT and DELETE methods respectively.
	// https://javabrains.io/courses/javaee_jaxrs/lessons/Implementing-Update-And-Delete
	@PUT
	@Path("/{profileName}")
	/// Moved to class level @Consumes(MediaType.APPLICATION_JSON)
	/// Moved to class level @Produces(MediaType.APPLICATION_JSON)
	public Profile updateProfile( @PathParam("profileName")  String name, Profile profile) {
		profile.setProfileName(name);
		return profileService.updateProfile(profile);
	}
	
	// Consumes is not requesd as it takes only id
	// it doesn't return anything so return type is void
	@DELETE
	@Path("/{profileName}")
	/// Moved to class level @Produces(MediaType.APPLICATION_JSON)
	public void removeProfile( @PathParam("profileName")  String name) {
		 profileService.removeProfile(name);
	}
}
