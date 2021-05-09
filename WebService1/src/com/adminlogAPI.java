package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class adminlogAPI
 */
@WebServlet("/adminlogAPI")
public class adminlogAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	user itemObj5 = new user(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminlogAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException 
    		{ 
    		 HttpSession session = request.getSession(); 
    		 String authStatus = itemObj5.loginAdmin(request.getParameter("usern"), 
    		 request.getParameter("pass")); 
    		 String output = ""; 
    		if (authStatus.equals("success")) 
    		 { 
    		 output = "{\"status\":\"success\", \"data\": \"\"}"; 
    		 session.setAttribute("usern", 
    		 request.getParameter("usern"));
    		 } 
    		else
    		 { 
    		 output = "{\"status\":\"error\", \"data\": \"" + authStatus + "\"}"; 
    		 } 
    		 response.getWriter().write(output); 
    		}
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
    		 throws ServletException, IOException 
    		{ 
    		 HttpSession session = request.getSession(); 
    		session.invalidate(); 
    		response.getWriter().write("success"); 
    		}

}
