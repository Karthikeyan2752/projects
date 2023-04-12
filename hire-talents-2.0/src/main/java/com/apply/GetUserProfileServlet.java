package com.apply;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class GetUserProfileServlet
 */
@WebServlet("/GetUserProfileServlet")
       
public class GetUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		String mobileNumber = (String) session.getAttribute("mobileNumber");
		String skills = (String) session.getAttribute("skills");
		String qualification = (String) session.getAttribute("qualification");
		String email = (String) session.getAttribute("email");
		int experience = (int) session.getAttribute("experience");
		String location = (String) session.getAttribute("location");
		String about = (String) session.getAttribute("about");

		JSONObject profile = new JSONObject();
		profile.put("name", name);
		profile.put("mobileNumber", mobileNumber);
		profile.put("skills", skills);
		profile.put("qualification", qualification);
		profile.put("email", email);
		profile.put("experience", experience);
		profile.put("location", location);
		profile.put("about", about);

		// Set response content type to JSON
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		// Write JSON response
		PrintWriter out = response.getWriter();
		out.print(profile.toString());
		out.flush();
	}

}
