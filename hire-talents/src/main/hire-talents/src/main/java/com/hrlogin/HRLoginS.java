package com.hrlogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.HR;
import com.repository.DB;

@WebServlet("/HRLoginS")
public class HRLoginS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		HR hr = DB.getInstance().getHR(Integer.parseInt(userid), password);
		if (hr != null) {
			HttpSession session = request.getSession();
			session.setAttribute("name", hr.getName());
			session.setAttribute("mobileNumber", hr.getMobileNumber());
			session.setAttribute("userID", hr.getId());
			session.setAttribute("email", hr.getEmail());
			session.setAttribute("companyName", hr.getCompanyName());
			response.sendRedirect("HRHome.jsp");
		} else {
			response.sendRedirect("HRLoginView.jsp");
		}
	}
}
