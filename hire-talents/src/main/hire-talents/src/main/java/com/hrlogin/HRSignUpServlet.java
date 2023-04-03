package com.hrlogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.HR;
import com.repository.DB;

/**
 * Servlet implementation class HRSignUpServlet
 */
@WebServlet("/HRSignUpServlet")
public class HRSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HRSignUpServlet() {
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
		String companyName = request.getParameter("companyName");

		// Check if passwords match
		if (!password.equals(repassword)) {
			response.sendRedirect("HRSignUp.jsp?error=password");
			return;
		}

		HR hr = DB.getInstance().hRSignin(name, email, companyName, repassword, mobileNumber);


		response.sendRedirect("HRLoginView.jsp?userID=" + hr.getId());

	}


}
