package com.hrcontrols;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.repository.DB;

/**
 * Servlet implementation class RemoveCandidate
 */
@WebServlet("/RemoveCandidate")
public class RemoveCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int jobID = Integer.parseInt(request.getParameter("jobID"));
		int userID = Integer.parseInt(request.getParameter("userID"));
		// int jobID = (Integer) (request.getSession().getAttribute("jobID"));

		String result = DB.getInstance().removeCandidate(userID, jobID);
		System.out.println(result);
		// response.sendRedirect("AppliedCandidates.jsp");
	}

}
