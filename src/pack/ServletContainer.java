package pack;

import javax.swing.text.NavigationFilter;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/Welcome")
public class ServletContainer {
	
	@GET
	@Path("/")
	public String WelcomeMethod(){
		return "Welcome";
	}
	
	@GET
	@Path("/2")
	public String WelcomeMethod2(){
		return "Welcome2";
	}
	
}
