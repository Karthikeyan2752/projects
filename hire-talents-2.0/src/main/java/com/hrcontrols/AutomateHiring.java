package com.hrcontrols;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.model.User;

/**
 * Servlet implementation class AutomateHiring
 */
@WebServlet("/AutomateHiring")
public class AutomateHiring extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutomateHiring() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		int jobID = Integer.parseInt(request.getParameter("jobID"));
		String venue = request.getParameter("venue");
		String time = request.getParameter("time");
		String date = request.getParameter("date");
		List<User> users = new HRControlViewModel().automateHiring(jobID, venue, date, time);
		JSONObject jsonResponse = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		for (User user : users) {
			JSONObject jsonCandidate = new JSONObject();
			jsonCandidate.put("name", user.getName());
			jsonCandidate.put("userID", user.getUserID());
			jsonCandidate.put("jobID", jobID);
			jsonCandidate.put("email", user.getEmail());
			jsonCandidate.put("skills", user.getSkills());
			jsonCandidate.put("experience", user.getExperience());
			jsonCandidate.put("about", user.getAbout());
			jsonCandidate.put("qualification", user.getQualification());
			jsonCandidate.put("location", user.getLocation());
			jsonCandidate.put("mobileNumber", user.getMobileNumber());
			jsonArray.add(jsonCandidate);
		}

		jsonResponse.put("candidates", jsonArray);
		response.getWriter().print(jsonResponse);
		response.getWriter().flush();

		// Send the redirect response after setting the response headers
		// response.sendRedirect("AppliedCandidates.jsp");
	}
}
