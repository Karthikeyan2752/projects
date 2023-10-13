package com.registration;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import com.mysql.jdbc.Driver;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	
	private String username;
    private String email;
    private String password;
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		JSONObject jsonResponse = new JSONObject();

		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			StringBuilder jsonBody = new StringBuilder();
			BufferedReader reader = request.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				jsonBody.append(line);
			}

			JSONObject jsonData = new JSONObject(jsonBody.toString());

			String username = jsonData.getString("username");
			String email = jsonData.getString("email");
			String password = jsonData.getString("password");
			System.out.println(username + " " + email + " " + " " + password);

			String jdbcUrl = "jdbc:mysql://localhost:3306/user_registration";
			String dbUser = "root";
			String dbPassword = "karthikn2752";

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

			String insertQuery = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);

			int rowsAffected = preparedStatement.executeUpdate();

			preparedStatement.close();
			connection.close();

			if (rowsAffected > 0) {
				jsonResponse.put("success", true);
				writeJsonResponse(jsonResponse);
				return SUCCESS;
			} else {
				jsonResponse.put("success", false);
				writeJsonResponse(jsonResponse);
				return INPUT;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			jsonResponse.put("success", false); 
			writeJsonResponse(jsonResponse);
			return ERROR;
		}
	}

	private void writeJsonResponse(JSONObject jsonResponse) {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			response.getWriter().write(jsonResponse.toString());
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
