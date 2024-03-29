package model;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;


import com.user;
import com.google.gson.*;






@Path("/user")
public class User_Service {

	user itemObj = new user(); 
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readUser() { 
		 
			 return itemObj.readUser(); 
	  
	
	 }
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertUser(@FormParam("first_name") String first_name, 
	 @FormParam("last_name") String last_name, 
	 @FormParam("em") String em, 
	 @FormParam("usern") String usern,
	 @FormParam("pass") String pass) 
	{ 
		
		String output = itemObj.insertUser(first_name, last_name, em, usern, pass);
	 
		return output; 
	
	}
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN)
	
	public String updateItem(String itemData) { 
		
		//Convert the input string to a JSON object 
		JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
	 
		//Read the values from the JSON object
		String id = itemObject.get("id").getAsString();
		String first_name = itemObject.get("first_name").getAsString(); 
		String last_name = itemObject.get("last_name").getAsString(); 
		String em = itemObject.get("em").getAsString();
		String usern = itemObject.get("usern").getAsString();
		String pass = itemObject.get("pass").getAsString(); 
		String output = itemObj.updateUser(id,first_name, last_name, em,usern, pass); 
		
		return output;
	
	}
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN)
	
	public String deleteUser(String userData) 
	{ 
	
		Document doc = Jsoup.parse(userData, "", Parser.xmlParser()); 
	 
	
	 String id =   doc.select("id").text(); 
	 String output = itemObj.deleteUser(id); 
	return output; 
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	
	
	public String getLog(String log) {
		
		Document doc = Jsoup.parse(log,"",Parser.xmlParser());
		
		String usern = doc.select("usern").text();
		String pass = doc.select("pass").text();
		
		String output = itemObj.login(usern, pass);
		
		return output;
		
	}
	
	user itemObj2 = new user(); 
	@GET
	@Path("/admin") 
	@Produces(MediaType.TEXT_HTML) 
	public String readAdmin() { 
		 
			 return itemObj2.readAdmin(); 
	  
	
	 }
	@POST
	@Path("/admin") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertAdmin(@FormParam("first_name") String first_name, 
	 @FormParam("last_name") String last_name, 
	 @FormParam("em") String em, 
	 @FormParam("usern") String usern,
	 @FormParam("pass") String pass) 
	{ 
		
		String output = itemObj2.insertAdmin(first_name, last_name, em, usern, pass);
	 
		return output; 
	
	}
	
	user itemObj3 = new user(); 
	@GET
	@Path("/research") 
	@Produces(MediaType.TEXT_HTML) 
	public String readResearch() { 
		 
			 return itemObj3.readResearch(); 
	  
	
	 }
	
	@POST
	@Path("/research") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertResearch(@FormParam("first_name") String first_name, 
	 @FormParam("last_name") String last_name, 
	 @FormParam("em") String em, 
	 @FormParam("usern") String usern,
	 @FormParam("pass") String pass) 
	{ 
		
		String output = itemObj3.insertResearch(first_name, last_name, em, usern, pass);
	 
		return output; 
	
	}
	
	@POST
	@Path("/loginAdmin")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	
	
	public String getLogAdmin(String log) {
		
		Document doc = Jsoup.parse(log,"",Parser.xmlParser());
		
		String usern = doc.select("usern").text();
		String pass = doc.select("pass").text();
		
		String output = itemObj2.loginAdmin(usern, pass);
		
		return output;
		
	}
	
	@POST
	@Path("/loginResearch")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	
	
	public String getLogReserch(String log) {
		
		Document doc = Jsoup.parse(log,"",Parser.xmlParser());
		
		String usern = doc.select("usern").text();
		String pass = doc.select("pass").text();
		
		String output = itemObj.loginResearch(usern, pass);
		
		return output;
		
	}
	


}
