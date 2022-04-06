/* 
 * Name: Yi-Wen Chu    991624614
 * Assignment: Midterm 
 * Program: Computer Systems Technology -
 * 	Software Development and Network Engineering
 * File: RegsiterServlet.java
 * Other Files in this Project: 
 * 	index.jsp
 * 
 * Date: Oct 20, 2021
 * 
 * Description: the registration function will validate each field.
 * 	This project is developed by Eclipse.
 */


import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class RegsiterServlet.
 *
 * @author Yi-Wen Chu
 * Computer Systems Technology
 * Software Development and Network Engineering
 */
@WebServlet(urlPatterns={"/RegsiterServlet"})
public class RegsiterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	/**
	 * Process request.
	 * Check each field in form.
	 * Name, UserID, Password must have 7 or more characters.
	 * Email must have a "@" symbol. 
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String result = "Registration failed.";
		StringBuffer errMsg = new StringBuffer();
		Map<String,String[]> formParams = request.getParameterMap();
		
		// check each parameter.
		for (String key: formParams.keySet()) {
			String paramVal = (formParams.get(key).length > 0)? 
					formParams.get(key)[0]:null;
			if(errMsg.length() > 0)
				errMsg.append("<br/>");
				
			switch(key) {
				case "Name":
				case "UserID":
				case "Password":
					// invalidation
					if(!checkLength(paramVal)) {
						errMsg.append(key + " must be 7 characters or more.");
					}
					break;
				case "Email":
					// invalidation
					if(!checkEmail(paramVal)) {
						errMsg.append(key + " must have @.");
					} 
					break;
				default:
					errMsg.append("invalid input field: "+key);
			}
			
		}
		
		// pass validation
		if(errMsg.length() == 0)
			result = "Registration is successful.";
		
		request.setAttribute("result", result);
		request.setAttribute("errMsg", errMsg);
		
		request.getRequestDispatcher("index.jsp")
						.forward(request, response);
	}
	
	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}
	
	// Check if length of input string has 7 or more characters. 
	private boolean checkLength(String input) {
		
		return (input != null && input.length() >= 7)? true: false; 
	}
	
	// Check if the symbol "@" is contained in the input string.
	private boolean checkEmail(String input) {
		
		return (input != null && input.contains("@"))? true: false;
	}

}
