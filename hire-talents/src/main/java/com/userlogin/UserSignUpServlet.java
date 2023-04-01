package com.userlogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import com.repository.DB;

/**
 * Servlet implementation class UserSignUpServlet
 */
@WebServlet("/UserSignUpServlet")
public class UserSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the form data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String mobileNumber = request.getParameter("contact");
		String skills = request.getParameter("skills");
		String qualification = request.getParameter("qualification");
		int experience = Integer.parseInt(request.getParameter("experience"));

		// Check if passwords match
		if (!password.equals(repassword)) {
			response.sendRedirect("UserSignUp.jsp?error=password");
			return;
		}
		HttpSession session = request.getSession();
		User user = DB.getInstance().createAndGetUser(name, email, qualification, password, mobileNumber, skills,
				experience);
		session.setAttribute("name", user.getName());
		session.setAttribute("mobileNumber", user.getMobileNumber());
		session.setAttribute("userID", user.getUserID());
		session.setAttribute("email", user.getEmail());
		session.setAttribute("experience", user.getExperience());
		session.setAttribute("skills", user.getSkills());
		session.setAttribute("qualification", user.getQualification());
		session.setAttribute("skills", user.getSkills());

		response.sendRedirect("UserLoginView.jsp?userID=" + user.getUserID());

	}


}
