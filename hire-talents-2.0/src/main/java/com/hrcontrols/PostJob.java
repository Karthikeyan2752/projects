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
		System.out.println(description);
		String title = request.getParameter("designation");
		String requirements = request.getParameter("requirements");
		System.out.println(requirements);
		String responsibilities = request.getParameter("responsibilities");
		String skills = request.getParameter("skills");
		String type = request.getParameter("type");
		System.out.println(type);
		int numberOfVacancies = Integer.parseInt(request.getParameter("a"));
		String location = request.getParameter("location");
		int experience = Integer.parseInt(request.getParameter("experience"));
		int HRID = (Integer) (request.getSession().getAttribute("userID"));
		int jobID = new HRControlViewModel().postJob(HRID, title, numberOfVacancies, skills, description, requirements,
				responsibilities, experience, type, location);
		if (jobID == 0) {
			response.getWriter().write("Job posting failed. Please try again."); // Response message for failure
		} else {
			response.getWriter().write("Job posted successfully."); // Response message for success
		}
	}

}
