package org.koushik.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.koushik.javabrains.messenger.model.Comment;
import org.koushik.javabrains.messenger.service.CommentService;

@Path("/")
public class CommentResource {
	
	CommentService commentService = new CommentService();

	@GET
	public List<Comment> getAllComments(@PathParam ("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam ("messageId") long messageId, @PathParam ("commentId") long commentId) {
		return commentService.getComment(messageId, commentId);
	}

	@POST
	public Comment addComment(  @PathParam ("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}
	
	
	@PUT
	@Path("/{commentId}")
	
	public Comment updateComment(  @PathParam ("messageId") long messageId, @PathParam ("commentId") long commentId, Comment comment) {
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	/// Moved to class level @Produces(MediaType.APPLICATION_JSON)
	public void removeComment( @PathParam ("messageId") long messageId, @PathParam ("commentId") long commentId) {
		commentService.removeComment(messageId, commentId);
	}
	
}
