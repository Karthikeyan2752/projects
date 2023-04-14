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

import com.model.CallLetter;
import com.model.HR;
import com.model.JobNotification;

/**
 * Servlet implementation class CallLetters
 */
@WebServlet("/CallLetters")
public class CallLetters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallLetters() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		int page = Integer.parseInt(request.getParameter("page"));
		int userID = (Integer) request.getSession().getAttribute("userID");
		int start = (page - 1) * 10;
		List<CallLetter> callLetters = new ApplyViewModel().getCallLetters(userID, start);
		JSONObject jsonResponse = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		for (CallLetter callLetter : callLetters) {
			JSONObject jsonJob = new JSONObject();
			HR hr = callLetter.getHr();
			JobNotification job = callLetter.getJob();
			jsonJob.put("jobID", job.getJobID());
			jsonJob.put("title", job.getJobTitle());
			jsonJob.put("noOfVacancies", job.getNumberOfVacancies());
			jsonJob.put("skill", job.getSkills());
			jsonJob.put("experience", job.getExperience());
			jsonJob.put("venue", callLetter.getVenue());
			jsonJob.put("time", callLetter.getTime());
			jsonJob.put("date", callLetter.getDate());
			jsonJob.put("requirements", job.getRequirements());
			jsonJob.put("responsibilities", job.getResponsibilities());
			jsonJob.put("type", job.getType());
			jsonJob.put("companyName", hr.getCompanyName());
			jsonJob.put("HRName", hr.getName());
			jsonJob.put("description", job.getDescription());
			jsonArray.add(jsonJob);
		}

		jsonResponse.put("callLetters", jsonArray);
		out.print(jsonResponse);
		// out.flush();
	}

}
