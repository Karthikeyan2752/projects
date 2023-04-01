package com.hrlogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.HR;
import com.repository.DB;

@WebServlet("/HRLoginS")
public class HRLoginS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		HR hr = DB.getInstance().getHR(Integer.parseInt(userid), password);
		if (hr != null) {
			response.sendRedirect("HRHomePage.jsp");
		} else {
			response.sendRedirect("HRLoginView.jsp");
		}
	}
}
