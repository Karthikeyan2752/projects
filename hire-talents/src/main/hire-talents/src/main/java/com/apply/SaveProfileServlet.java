package com.apply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.repository.DB;

/**
 * Servlet implementation class SaveProfileServlet
 */
@WebServlet("/SaveProfileServlet")
public class SaveProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID = (int) request.getSession().getAttribute("userID");

		// Get the updated profile data from the form submission
		String name = request.getParameter("name");
		String mobileNumber = request.getParameter("mobileNumber");
		String skills = request.getParameter("skills");
		String qualification = request.getParameter("qualification");
		String email = request.getParameter("email");
		int experience = Integer.parseInt(request.getParameter("experience"));
		DB.getInstance().updateUser(userID, name, mobileNumber, skills, qualification, email, experience);

		// Redirect the user to the profile page
		response.sendRedirect("Profile.jsp");
	}

}