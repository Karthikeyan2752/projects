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

import com.model.User;
import com.repository.DB;

/**
 * Servlet implementation class FetchAppliedCandidates
 */
@WebServlet("/FetchAppliedCandidates")
public class FetchAppliedCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchAppliedCandidates() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		int page = Integer.parseInt(request.getParameter("page"));
		int jobID = Integer.parseInt(request.getParameter("jobID"));
		int start = (page - 1) * 10;
		List<User> users = DB.getInstance().getAppliedCandidates(start, jobID);
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
		out.print(jsonResponse);
		// out.flush();
	}

}
