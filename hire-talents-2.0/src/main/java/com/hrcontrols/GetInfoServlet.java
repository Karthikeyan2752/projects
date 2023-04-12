package com.hrcontrols;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class GetInfoServlet
 */
@WebServlet("/GetInfoServlet")
public class GetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		String mobileNumber = (String) session.getAttribute("mobileNumber");
		int id = (int) session.getAttribute("userID");
		String email = (String) session.getAttribute("email");
		String companyName = (String) session.getAttribute("companyName");
		String about = (String) session.getAttribute("about");
		String location = (String) session.getAttribute("location");
		String website = (String) session.getAttribute("website");
		JSONObject jsonResponse = new JSONObject();

		jsonResponse.put("name", name);
		jsonResponse.put("about", about);
		jsonResponse.put("location", location);
		jsonResponse.put("companyName", companyName);
		jsonResponse.put("mobileNumber", mobileNumber);
		jsonResponse.put("userID", id);
		jsonResponse.put("website", website);
		jsonResponse.put("email", email);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);

	}

}
