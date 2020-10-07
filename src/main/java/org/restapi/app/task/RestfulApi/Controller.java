package org.restapi.app.task.RestfulApi;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/loginHome")
public class Controller {


	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/loginWithoutSecure")
	public String login(@QueryParam("user") String user,@QueryParam("password") String password) {
	return	JWTToken.createJWT( user, "", "", new Date().getSeconds()* 1000);
		
	}
	
	

	@GET
	@Path("/secureToken")
	@Produces(MediaType.TEXT_PLAIN)
	
	public String Secure(@HeaderParam("token") String token) {
		try
		{
		JWTToken.decodeJWT(token);
		return "Authentecated Sucessfully ...";
		}
		catch(Throwable e)
		{
			
		}
		return "Authentecation Failed ...!!";
	}
	

}