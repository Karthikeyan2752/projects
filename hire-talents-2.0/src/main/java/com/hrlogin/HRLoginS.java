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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HR hr = DB.getInstance().getHR(email, password);
		int postedJobs = DB.getInstance().getPostedJobsCount(hr.getId());
		int selectedCandidates = DB.getInstance().getSelectedCandidatesCount(hr.getId());

		if (hr != null) {
			HttpSession session = request.getSession();
			session.setAttribute("name", hr.getName());
			session.setAttribute("mobileNumber", hr.getMobileNumber());
			session.setAttribute("userID", hr.getId());
			session.setAttribute("email", hr.getEmail());
			session.setAttribute("companyName", hr.getCompanyName());
			session.setAttribute("about", hr.getAbout());
			session.setAttribute("location", hr.getLocation());
			session.setAttribute("website", hr.getWebsiteURL());
			session.setAttribute("postedJobs", postedJobs);
			session.setAttribute("hiredCandidates", selectedCandidates);
			response.sendRedirect("HRHome.jsp");
		} else {
			response.sendRedirect("HRLoginView.jsp");
		}
	}
}
