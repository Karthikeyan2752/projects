package com.hrcontrols;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostJob
 */
@WebServlet("/PostJob")
public class PostJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		String title = request.getParameter("jobTitle");
		int numberOfVacancies = Integer.parseInt(request.getParameter("numberOfVacancies"));
		String applicationEndDate = request.getParameter("applicationEndDate");
		String skills = request.getParameter("skills");
		int HRID = (Integer) (request.getSession().getAttribute("userID"));
		int jobID = new HRControlViewModel().postJob(HRID, title, numberOfVacancies, applicationEndDate, skills,
				description);
		response.sendRedirect("PostJob.jsp");

	}

}
