package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class user {

	// connect to the database
	private Connection connect() { 
	 
		Connection con = null; 
			try{ 
				
					Class.forName("com.mysql.jdbc.Driver"); 
	 
					//database name, username , password
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/code", "root", "root"); 
			} 
			catch (Exception e) {
				
				e.printStackTrace();
				
			} 
			
			return con; 
	 } 
	
	
	
	
	public String insertUser(String first_name, String last_name, String em, String usern, String pass) { 
	 
		String output = "";
		
		try{ 
			
			Connection con = connect();
			
			if (con == null) {
				
				return "Error while connecting to the database for inserting."; 
				
			} 
			
			//query
			String query = " insert into user (`first_name`,`last_name`,`em`,`usern`, `pass`)"+ " values (?, ?, ?, ?, ?)"; 
			
			//create preparestatement
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			
			// set values
			preparedStmt.setString(1, first_name); 
			preparedStmt.setString(2, last_name); 
			preparedStmt.setString(3, em); 
			preparedStmt.setString(4, usern); 
			preparedStmt.setString(5, pass); 
	 
			//execute
			preparedStmt.execute(); 
			con.close();
			
			String newUser = readUser(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
			 newUser + "\"}"; 
			
		} 
		catch (Exception e) { 
			output = "{\"status\":\"error\", \"data\":  \"Error while inserting the user.\"}"; 
					 System.err.println(e.getMessage()); 
		} 
		
		return output; 
	 } 
	
	public String readUser() { 
		
		String output = ""; 
		
		
			try{ 
				
				Connection con = connect(); 
				
				if (con == null) {
					
					return "Error while connecting to the database for reading."; 
					
				} 
	 
				//create html table
				output = "<table border=\"1\"><tr> <th>First Name</th> <th>Last Name</th> <th>Email</th> <th>Username</th> <th>Password</th> <th>Update</th><th>Remove</th></tr>"; 
				
				//query
				String query = "select * from user"; 
				//create statement
				Statement stmt = (Statement) con.createStatement(); 
				
				//create resultset
				ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
				
				
				while (rs.next()) { 
					
						String id = Integer.toString(rs.getInt("id")); 
						String first_name = rs.getString("first_name"); 
						String last_name = rs.getString("last_name"); 
						String em =rs.getString("em"); 
						String usern = rs.getString("usern"); 
						String pass = rs.getString("pass");
						
						// Add into the html table
						output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='" + id + "'>"
								 + first_name + "</td>";
								 //output += "<td>"+ first_name + "</td>"; 
								 output += "<td>" + last_name + "</td>"; 
								 output += "<td>" + em + "</td>"; 
								 output += "<td>" + usern + "</td>";
								 output += "<td>" + pass + "</td>";
						
						
						
						// buttons
								 output += "<td><input name='btnUpdate' type='button' value='Upadate' class='btnUpdate btn btn-danger' data-id='" + id + "'>"
										 +"</td>"
										 +"<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-id='" + id + "'></td>";
										

								 
								 
								 
								 
									
				}
				
				con.close(); 
				output += "</table>";
			} 
			catch (Exception e) { 
				
				 output = "{\"status\":\"error\", \"data\":  \"Error while updating the user.\"}"; 
				 System.err.println(e.getMessage()); 
			 
	 
			} 
			return output; 
	
	} 
	
	public String updateUser(String id,String first_name, String last_name, String em, String usern, String pass){ 
		
		
		 String output = ""; 
		 
		 try{
			 
			 
			 Connection con = connect(); 
			 
			 if (con == null) {
				 
				 return "Error while connecting to the database for updating."; 
				 
			 } 
			 
			 
			 	// query
			 	String query = "UPDATE user SET first_name=?,last_name=?,em=?,usern=?, pass=? WHERE id=?"; 
			 	
			 	//create statement
			 	PreparedStatement preparedStmt = con.prepareStatement(query); 
			 	
			 	
			 		// set values
			 		
			 		preparedStmt.setString(1, first_name); 
			 		preparedStmt.setString(2, last_name); 
			 		preparedStmt.setString(3, em); 
			 		preparedStmt.setString(4, usern); 
			 		preparedStmt.setString(5, pass);
			 		preparedStmt.setInt(6, Integer.parseInt(id));
			 		
			 		// execute the statement
			 		preparedStmt.execute(); 
			 		con.close();
			 		
			 		String newUser = readUser(); 
					 output = "{\"status\":\"success\", \"data\": \"" + 
					 newUser + "\"}"; 
		 
		 } 
		 
		 
		 catch (Exception e) { 
			 
			 output = "{\"status\":\"error\", \"data\":  \"Error while updating the user.\"}"; 
			 System.err.println(e.getMessage()); 
		 
		 }
		 
		 return output; 
		 
	} 
	
	
		public String deleteUser(String id) { 
			
			
		 String output = ""; 
		 
		 try{ 
			 
			 
			 	Connection con = connect(); 
			 	
			 	
			 		if (con == null) {
			 			
			 			return "Error while connecting to the database for deleting.";
			 			
			 		} 
			 		
			 		
			 			// query
			 			String query = "delete from user where id=?"; 
			 			
			 			//create statment
			 			PreparedStatement preparedStmt = con.prepareStatement(query);
			 			
			 			
			 			// binding values
			 			preparedStmt.setInt(1, Integer.parseInt(id)); 
			 			
			 			// execute the statement
			 			preparedStmt.execute(); 
			 			con.close(); 
			 			
			 			String newUser = readUser(); 
						 output = "{\"status\":\"success\", \"data\": \"" + 
						 newUser + "\"}"; 
		 
		 } 
		 
		 catch (Exception e) {
			 
			 output = "{\"status\":\"error\", \"data\":  \"Error while deleting the user.\"}"; 
			 System.err.println(e.getMessage());
		 } 
		 
		 	return output; 
		 
		} 
		
		public String login(String usern, String pass) {
			
			String output ="";
			
			try {
				
				Connection con = connect();
				
				if(con == null) {
					
					return "error while connecting to dadabase";
				}
				
				System.out.println("error");
				
				//query
				String query = "select `usern`, `pass` from user where usern =? and pass=?";
				
				//create statement
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				System.out.println(preparedStmt);
				System.out.println(usern);
				System.out.println(pass);
				
				preparedStmt.setString(1, usern);
				preparedStmt.setString(2, pass);
				
				ResultSet rs = preparedStmt.executeQuery();
				
				
				if(rs.next()) {
					
					con.close();
					output = "success";
				}
				else {
					
					con.close();
					if(usern.equals("")) {
						
						return "User cannot be empty";
					}
					else if(pass.equals("")) {
						
						return "password cannot be empty";
						
					}
					
					else {
						
						return "incorrect username or password";
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				output = "Error while deleting the user."; 
				 System.err.println(e.getMessage()); 
				
			}
			return output;
		}
		
		
		public String insertAdmin(String first_name, String last_name, String em, String usern, String pass) { 
			 

			String output = "";
			
			try{ 
				
				Connection con = connect();
				
				if (con == null) {
					
					return "Error while connecting to the database for inserting."; 
					
				} 
				
				//query
				String query = " insert into admin (`first_name`,`last_name`,`em`,`usern`, `pass`)"+ " values (?, ?, ?, ?, ?)"; 
				
				//create preparestatement
				PreparedStatement preparedStmt = con.prepareStatement(query); 
				
				// set values
				preparedStmt.setString(1, first_name); 
				preparedStmt.setString(2, last_name); 
				preparedStmt.setString(3, em); 
				preparedStmt.setString(4, usern); 
				preparedStmt.setString(5, pass); 
		 
				//execute
				preparedStmt.execute(); 
				con.close();
				
				String newUser = readUser(); 
				 output = "{\"status\":\"success\", \"data\": \"" + 
				 newUser + "\"}"; 
				
			} 
			catch (Exception e) { 
				output = "{\"status\":\"error\", \"data\":  \"Error while inserting the admin.\"}"; 
						 System.err.println(e.getMessage()); 
			} 
			
			return output; 
		 } 
		
		public String readAdmin() { 
			
			String output = ""; 
			
			
			try{ 
				
				Connection con = connect(); 
				
				if (con == null) {
					
					return "Error while connecting to the database for reading."; 
					
				} 
	 
				//create html table
				output = "<table border=\"1\"><tr> <th>First Name</th> <th>Last Name</th> <th>Email</th> <th>Username</th> <th>Password</th> <th>Update</th><th>Remove</th></tr>"; 
				
				//query
				String query = "select * from admin"; 
				//create statement
				Statement stmt = (Statement) con.createStatement(); 
				
				//create resultset
				ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
				
				
				while (rs.next()) { 
					
						String id = Integer.toString(rs.getInt("id")); 
						String first_name = rs.getString("first_name"); 
						String last_name = rs.getString("last_name"); 
						String em =rs.getString("em"); 
						String usern = rs.getString("usern"); 
						String pass = rs.getString("pass");
						
						// Add into the html table
						output += "<tr><td><input id='hidItemIDUpdateA' name='hidItemIDUpdateA' type='hidden' value='" + id + "'>"
								 + first_name + "</td>";
								 //output += "<td>"+ first_name + "</td>"; 
								 output += "<td>" + last_name + "</td>"; 
								 output += "<td>" + em + "</td>"; 
								 output += "<td>" + usern + "</td>";
								 output += "<td>" + pass + "</td>";
						
						
						
						// buttons
								 output += "<td><input name='btnUpdateA' type='button' value='Upadate' class='btnUpdateA btn btn-danger' data-id='" + id + "'>"
										 +"</td>"
										 +"<td><input name='btnRemoveA' type='button' value='Remove' class='btnRemoveA btn btn-danger' data-id='" + id + "'></td>";
										

								 
								 
								 
								 
									
				}
				
				con.close(); 
				output += "</table>";
			} 
			catch (Exception e) { 
				
				 output = "{\"status\":\"error\", \"data\":  \"Error while updating the admin.\"}"; 
				 System.err.println(e.getMessage()); 
			 
	 
			} 
			return output; 
	
	} 
		
		public String updateAdmin(String id,String first_name, String last_name, String em, String usern, String pass){ 
			
			
			 String output = ""; 
			 
			 try{
				 
				 
				 Connection con = connect(); 
				 
				 if (con == null) {
					 
					 return "Error while connecting to the database for updating."; 
					 
				 } 
				 
				 
				 	// query
				 	String query = "UPDATE admin SET first_name=?,last_name=?,em=?,usern=?, pass=? WHERE id=?"; 
				 	
				 	//create statement
				 	PreparedStatement preparedStmt = con.prepareStatement(query); 
				 	
				 	
				 		// set values
				 		
				 		preparedStmt.setString(1, first_name); 
				 		preparedStmt.setString(2, last_name); 
				 		preparedStmt.setString(3, em); 
				 		preparedStmt.setString(4, usern); 
				 		preparedStmt.setString(5, pass);
				 		preparedStmt.setInt(6, Integer.parseInt(id));
				 		
				 		// execute the statement
				 		preparedStmt.execute(); 
				 		con.close();
				 		
				 		String newUser = readUser(); 
						 output = "{\"status\":\"success\", \"data\": \"" + 
						 newUser + "\"}"; 
			 
			 } 
			 
			 
			 catch (Exception e) { 
				 
				 output = "{\"status\":\"error\", \"data\":  \"Error while updating the user.\"}"; 
				 System.err.println(e.getMessage()); 
			 
			 }
			 
			 return output; 
			 
		} 
		
		public String deleteAdmin(String id) { 
			
			
			 String output = ""; 
			 
			 try{ 
				 
				 
				 	Connection con = connect(); 
				 	
				 	
				 		if (con == null) {
				 			
				 			return "Error while connecting to the database for deleting.";
				 			
				 		} 
				 		
				 		
				 			// query
				 			String query = "delete from admin where id=?"; 
				 			
				 			//create statment
				 			PreparedStatement preparedStmt = con.prepareStatement(query);
				 			
				 			
				 			// binding values
				 			preparedStmt.setInt(1, Integer.parseInt(id)); 
				 			
				 			// execute the statement
				 			preparedStmt.execute(); 
				 			con.close(); 
				 			
				 			String newUser = readUser(); 
							 output = "{\"status\":\"success\", \"data\": \"" + 
							 newUser + "\"}"; 
			 
			 } 
			 
			 catch (Exception e) {
				 
				 output = "{\"status\":\"error\", \"data\":  \"Error while deleting the user.\"}"; 
				 System.err.println(e.getMessage());
			 } 
			 
			 	return output; 
			 
			} 
		
		
		public String insertResearch(String first_name, String last_name, String em, String usern, String pass) { 
			 
			String output = "";
			
			try{ 
				
				Connection con = connect();
				
				if (con == null) {
					
					return "Error while connecting to the database for inserting."; 
					
				} 
				
				//query
				String query = " insert into research (`first_name`,`last_name`,`em`,`usern`, `pass`)"+ " values (?, ?, ?, ?, ?)"; 
				
				//create preparestatement
				PreparedStatement preparedStmt = con.prepareStatement(query); 
				
				// set values
				preparedStmt.setString(1, first_name); 
				preparedStmt.setString(2, last_name); 
				preparedStmt.setString(3, em); 
				preparedStmt.setString(4, usern); 
				preparedStmt.setString(5, pass); 
		 
				//execute
				preparedStmt.execute(); 
				con.close();
				
				String newUser = readUser(); 
				 output = "{\"status\":\"success\", \"data\": \"" + 
				 newUser + "\"}"; 
				
			} 
			catch (Exception e) { 
				output = "{\"status\":\"error\", \"data\":  \"Error while inserting the researcher.\"}"; 
						 System.err.println(e.getMessage()); 
			} 
			
			return output; 
		 } 
			
		public String readResearch() { 
			
			String output = ""; 
			
			
			try{ 
				
				Connection con = connect(); 
				
				if (con == null) {
					
					return "Error while connecting to the database for reading."; 
					
				} 
	 
				//create html table
				output = "<table border=\"1\"><tr> <th>First Name</th> <th>Last Name</th> <th>Email</th> <th>Username</th> <th>Password</th> <th>Update</th><th>Remove</th></tr>"; 
				
				//query
				String query = "select * from research"; 
				//create statement
				Statement stmt = (Statement) con.createStatement(); 
				
				//create resultset
				ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
				
				
				while (rs.next()) { 
					
						String id = Integer.toString(rs.getInt("id")); 
						String first_name = rs.getString("first_name"); 
						String last_name = rs.getString("last_name"); 
						String em =rs.getString("em"); 
						String usern = rs.getString("usern"); 
						String pass = rs.getString("pass");
						
						// Add into the html table
						output += "<tr><td><input id='hidItemIDUpdateR' name='hidItemIDUpdateR' type='hidden' value='" + id + "'>"
								 + first_name + "</td>";
								 //output += "<td>"+ first_name + "</td>"; 
								 output += "<td>" + last_name + "</td>"; 
								 output += "<td>" + em + "</td>"; 
								 output += "<td>" + usern + "</td>";
								 output += "<td>" + pass + "</td>";
						
						
						
						// buttons
								 output += "<td><input name='btnUpdateR' type='button' value='Upadate' class='btnUpdateR btn btn-danger' data-id='" + id + "'>"
										 +"</td>"
										 +"<td><input name='btnRemoveR' type='button' value='Remove' class='btnRemoveR btn btn-danger' data-id='" + id + "'></td>";
										

								 
								 
								 
								 
									
				}
				
				con.close(); 
				output += "</table>";
			} 
			catch (Exception e) { 
				
				 output = "{\"status\":\"error\", \"data\":  \"Error while updating the research.\"}"; 
				 System.err.println(e.getMessage()); 
			 
	 
			} 
			return output; 
	
	} 
		
		public String updateResearch(String id,String first_name, String last_name, String em, String usern, String pass){ 
			
			
			 String output = ""; 
			 
			 try{
				 
				 
				 Connection con = connect(); 
				 
				 if (con == null) {
					 
					 return "Error while connecting to the database for updating."; 
					 
				 } 
				 
				 
				 	// query
				 	String query = "UPDATE research SET first_name=?,last_name=?,em=?,usern=?, pass=? WHERE id=?"; 
				 	
				 	//create statement
				 	PreparedStatement preparedStmt = con.prepareStatement(query); 
				 	
				 	
				 		// set values
				 		
				 		preparedStmt.setString(1, first_name); 
				 		preparedStmt.setString(2, last_name); 
				 		preparedStmt.setString(3, em); 
				 		preparedStmt.setString(4, usern); 
				 		preparedStmt.setString(5, pass);
				 		preparedStmt.setInt(6, Integer.parseInt(id));
				 		
				 		// execute the statement
				 		preparedStmt.execute(); 
				 		con.close();
				 		
				 		String newUser = readUser(); 
						 output = "{\"status\":\"success\", \"data\": \"" + 
						 newUser + "\"}"; 
			 
			 } 
			 
			 
			 catch (Exception e) { 
				 
				 output = "{\"status\":\"error\", \"data\":  \"Error while updating the user.\"}"; 
				 System.err.println(e.getMessage()); 
			 
			 }
			 
			 return output; 
			 
		} 
		
		public String deleteResearch(String id) { 
			
			
			 String output = ""; 
			 
			 try{ 
				 
				 
				 	Connection con = connect(); 
				 	
				 	
				 		if (con == null) {
				 			
				 			return "Error while connecting to the database for deleting.";
				 			
				 		} 
				 		
				 		
				 			// query
				 			String query = "delete from research where id=?"; 
				 			
				 			//create statment
				 			PreparedStatement preparedStmt = con.prepareStatement(query);
				 			
				 			
				 			// binding values
				 			preparedStmt.setInt(1, Integer.parseInt(id)); 
				 			
				 			// execute the statement
				 			preparedStmt.execute(); 
				 			con.close(); 
				 			
				 			String newUser = readUser(); 
							 output = "{\"status\":\"success\", \"data\": \"" + 
							 newUser + "\"}"; 
			 
			 } 
			 
			 catch (Exception e) {
				 
				 output = "{\"status\":\"error\", \"data\":  \"Error while deleting the user.\"}"; 
				 System.err.println(e.getMessage());
			 } 
			 
			 	return output; 
			 
			} 
		
		

		public String loginAdmin(String usern, String pass) {
			
			String output ="";
			
			try {
				
				Connection con = connect();
				
				if(con == null) {
					
					return "error while connecting to dadabase";
				}
				
				System.out.println("error");
				
				//query
				String query = "select `usern`, `pass` from admin where usern =? and pass=?";
				
				//create statement
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				System.out.println(preparedStmt);
				System.out.println(usern);
				System.out.println(pass);
				
				preparedStmt.setString(1, usern);
				preparedStmt.setString(2, pass);
				
				ResultSet rs = preparedStmt.executeQuery();
				
				
				if(rs.next()) {
					
					con.close();
					output = "success";
				}
				else {
					
					con.close();
					if(usern.equals("")) {
						
						return "User cannot be empty";
					}
					else if(pass.equals("")) {
						
						return "password cannot be empty";
						
					}
					
					else {
						
						return "incorrect username or password";
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				output = "Error while deleting the user."; 
				 System.err.println(e.getMessage()); 
				
			}
			return output;
		}
		
		
		

		public String loginResearch(String usern, String pass) {
			
			String output ="";
			
			try {
				
				Connection con = connect();
				
				if(con == null) {
					
					return "error while connecting to dadabase";
				}
				
				System.out.println("error");
				
				//query
				String query = "select `usern`, `pass` from research where usern =? and pass=?";
				
				//create statement
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				System.out.println(preparedStmt);
				System.out.println(usern);
				System.out.println(pass);
				
				preparedStmt.setString(1, usern);
				preparedStmt.setString(2, pass);
				
				ResultSet rs = preparedStmt.executeQuery();
				
				
				if(rs.next()) {
					
					con.close();
					output = "success";
				}
				else {
					
					con.close();
					if(usern.equals("")) {
						
						return "User cannot be empty";
					}
					else if(pass.equals("")) {
						
						return "password cannot be empty";
						
					}
					
					else {
						
						return "incorrect username or password";
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				output = "Error while deleting the user."; 
				 System.err.println(e.getMessage()); 
				
			}
			return output;
		}
		
		

}
