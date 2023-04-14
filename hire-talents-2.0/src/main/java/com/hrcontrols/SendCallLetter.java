package com.hrcontrols;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendCallLetter
 */
@WebServlet("/SendCallLetter")
public class SendCallLetter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendCallLetter() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID = Integer.parseInt(request.getParameter("userID"));
		int jobID = Integer.parseInt(request.getParameter("jobID"));
		String venue = request.getParameter("venue");
		String time = request.getParameter("time");
		String date = request.getParameter("date");
		String result = new HRControlViewModel().sendCallLetter(userID, jobID, venue, date, time);
		response.getWriter().print(result);

		// Send the redirect response after setting the response headers
		// response.sendRedirect("AppliedCandidates.jsp");
	}


}
