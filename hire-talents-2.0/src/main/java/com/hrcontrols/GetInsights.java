package com.hrcontrols;

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

/**
 * Servlet implementation class GetInsights
 */
@WebServlet("/GetInsights")
public class GetInsights extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInsights() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		int userID = (Integer) request.getSession().getAttribute("userID");
		JSONObject jsonResponse = new JSONObject();
		HRControlViewModel hRControlViewModel = new HRControlViewModel();
		JSONObject head = new JSONObject();
		JSONArray table = new JSONArray();
		
		List<JobNotification> jobs = hRControlViewModel.getJobsPostedByHR(userID);
		int totalNoOfJobsPosted = hRControlViewModel.getTotalNoOfJobsPosted(userID);
		int totalNoOfSelectedCandidates = hRControlViewModel.getTotalNoOfSelectedCandidates(userID);
		
		head.put("jobsPosted", totalNoOfJobsPosted);
		head.put("selectedCandidates", totalNoOfSelectedCandidates);
		head.put("companyName", hRControlViewModel.getCompanyName(userID));

		for(JobNotification job : jobs) {
			JSONObject jsonJob = new JSONObject();
			jsonJob.put("role", job.getJobTitle());
			jsonJob.put("skills", job.getSkills());
			jsonJob.put("experience", job.getExperience());
			jsonJob.put("location", job.getLocation());
			int appliedCandidates = hRControlViewModel.getNoOfAppliedCandidates(job.getID());
			int selectedCandidates = hRControlViewModel.getNoOfSelectedCandidates(job.getID());
			jsonJob.put("appliedCandidates", appliedCandidates);
			jsonJob.put("selectedCandidates", selectedCandidates);
			table.add(jsonJob);
		}

		jsonResponse.put("table", table);
		jsonResponse.put("head", head);
		
		out.print(jsonResponse);

	}


}
