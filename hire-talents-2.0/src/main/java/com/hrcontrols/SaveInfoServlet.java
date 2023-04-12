package com.hrcontrols;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.repository.DB;

/**
 * Servlet implementation class SaveInfoServlet
 */
@WebServlet("/SaveInfoServlet")
public class SaveInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID = (int) request.getSession().getAttribute("userID");
		String name = request.getParameter("name");
		String mobileNumber = request.getParameter("mobileNumber");
		String website = request.getParameter("website");
		String companyName = request.getParameter("companyName");
		String email = request.getParameter("email");
		String location = request.getParameter("location");
		String about = request.getParameter("about");
		DB.getInstance().updateHR(userID, name, mobileNumber, website, companyName, email, location, about);

		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("mobileNumber", mobileNumber);
		session.setAttribute("email", email);
		session.setAttribute("companyName", companyName);
		session.setAttribute("about", about);
		session.setAttribute("location", location);
		session.setAttribute("website", website);
		response.sendRedirect("HRHome.jsp");
	}

}
