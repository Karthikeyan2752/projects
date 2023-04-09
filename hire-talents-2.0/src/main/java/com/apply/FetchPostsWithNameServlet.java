package com.apply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.model.JobNotification;
import com.repository.DB;

/**
 * Servlet implementation class FetchPostsWithNameServlet
 */
@WebServlet("/FetchPostsWithNameServlet")
public class FetchPostsWithNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchPostsWithNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		int page = Integer.parseInt(request.getParameter("page"));
		String title = request.getParameter("title");
		int userID = (Integer) request.getSession().getAttribute("userID");
		int start = (page - 1) * 10;
		List<JobNotification> jobs = DB.getInstance().fetchJobsFromDatabaseWithName(start, userID, title);

		JSONObject jsonResponse = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		for (JobNotification job : jobs) {
			JSONObject jsonJob = new JSONObject();
			jsonJob.put("jobID", job.getJobID());

			jsonJob.put("title", job.getJobTitle());
			jsonJob.put("noOfVacancies", job.getNumberOfVacancies());
			jsonJob.put("skill", job.getSkills());
			jsonJob.put("experience", job.getExperience());
			jsonJob.put("location", job.getLocation());
			jsonJob.put("requirement", job.getRequirements());
			jsonJob.put("responsibilities", job.getResponsibilities());
			jsonJob.put("type", job.getType());
			jsonJob.put("description", job.getDescription());
			jsonArray.add(jsonJob);
		}

		jsonResponse.put("jobs", jsonArray);
		out.print(jsonResponse);
		// out.flush();
	}
}
