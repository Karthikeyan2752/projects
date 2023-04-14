package com.apply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String name = request.getParameter("name");
		String mobileNumber = request.getParameter("mobileNumber");
		String skills = request.getParameter("skills");
		String qualification = request.getParameter("qualification");
		String location = request.getParameter("location");
		String about = request.getParameter("about");
		int experience = Integer.parseInt(request.getParameter("experience"));

		String result = new ApplyViewModel().updateUser(userID, name, mobileNumber, skills, qualification, experience,
				location,
				about);
		response.getWriter().print(result);
		response.sendRedirect("UserHomePage.jsp");
	}

}
