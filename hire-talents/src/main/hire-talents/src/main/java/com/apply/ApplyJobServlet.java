package com.apply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.repository.DB;

@WebServlet("/ApplyJobServlet")
public class ApplyJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the job ID from the request parameters
		int jobID = Integer.parseInt(request.getParameter("jobId"));

		// Apply the job for the current user
		int userID = (Integer) request.getSession().getAttribute("userID");
		DB.getInstance().apply(userID, jobID);

		// Redirect the user back to the job listing page
		response.sendRedirect("ShowJobs.jsp");
    }
}
