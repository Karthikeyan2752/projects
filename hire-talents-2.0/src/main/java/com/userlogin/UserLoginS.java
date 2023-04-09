package com.userlogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;

@WebServlet("/UserLoginS")
public class UserLoginS extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static User user = null;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		user = new UserLoginViewModel().userLogin(email, password);
		HttpSession session = request.getSession();
		session.setAttribute("name", user.getName());
		session.setAttribute("mobileNumber", user.getMobileNumber());
		session.setAttribute("userID", user.getUserID());
		session.setAttribute("email", user.getEmail());
		session.setAttribute("experience", user.getExperience());
		session.setAttribute("skills", user.getSkills());
		session.setAttribute("qualification", user.getQualification());
		session.setAttribute("skills", user.getSkills());
		int appliedJobs = new UserLoginViewModel().getAppliedJobsCount(user.getUserID());
		int selectedJobs = new UserLoginViewModel().getSelectedJobsCount(user.getUserID());
		session.setAttribute("appliedJobs", appliedJobs);
		session.setAttribute("selectedJobs", selectedJobs);

		if (user != null) {
			response.sendRedirect("UserHomePage.jsp");
		} else {
			response.sendRedirect("UserLoginView.jsp");
		}
	}

	public static User getUser() {
		return user;
	}

}
