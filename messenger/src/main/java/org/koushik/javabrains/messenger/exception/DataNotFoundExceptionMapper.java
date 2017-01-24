package org.koushik.javabrains.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.koushik.javabrains.messenger.model.ErrorMessage;

//https://javabrains.io/courses/javaee_jaxrs/lessons/Handling-Exceptions 

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "Http://Somelink");
				
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
