package org.koushik.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("demoHeaderParam")

	public String demoHeaderParam(
			@HeaderParam("authSessionId") String authSessionId) {
			return " headerParam is " + authSessionId;
	}
	
	@GET
	@Path("demoContextParam")
	public String demoContextParam(
			@Context UriInfo uriInfo,
			@Context HttpHeaders httpHeaders
			) {
		
			return " uriInfo Val is " + uriInfo.getPath() 
			+ "  header Param is :" + httpHeaders.getHeaderString("authSessionId");
	}
	
	@GET
	@Path("demoCookieParam")
	public String demoCookieParam(
			@CookieParam("name") String cookieVal) {
			return " cookie Val is " + cookieVal;
	}
	
}
