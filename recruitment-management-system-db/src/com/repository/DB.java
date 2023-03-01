package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.dto.HR;
import com.dto.JobNotification;
import com.dto.User;

public class DB {

	public static DB dBRInstance;
	private static Connection connection;

	private DB() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rms", "root", "Karthikn2752");
		} catch (Exception e) {
			System.out.println("DB connection failed");
		}
	}

	public static DB getInstance() {
		
		if (dBRInstance == null) {
			dBRInstance = new DB();
			dBRInstance.initialSetup();
		}
		return dBRInstance;
	}

	private void initialSetup() {

	}

	public JobNotification getJob(int jobID) {// HR hr,
		JobNotification job = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String query = "select * from job where jid=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, jobID);
			result = statement.executeQuery();
			String title = result.getString("title");
			Date date = result.getDate("endDate");
			int noOfVacancies = result.getInt("noOfVacancies");
			int hRID = result.getInt("hrId");
			HR hr = getHR(hRID);
			String skillString = result.getString("skill");
			List<String> skills = Arrays.asList(skillString.split(","));
			job = new JobNotification(jobID, title, date, skills, hr, noOfVacancies);

		} catch (Exception e) {

		}

		return job;
	}

	private HR getHR(int hRID) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(int userID, String password) {
		PreparedStatement statement = null;
		ResultSet result = null;
		User user = null;

		try {
			String query = "select * from users where id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,userID);
			result = statement.executeQuery();
			int id = result.getInt("id");
			String name = result.getString("name");
			String skillString = result.getString("skill");
			List<String> skills = Arrays.asList(skillString.split(","));
			System.out.println(id + name + skillString);

//			String query2 = "select * from appliedcandidates where uid=?";
//			statement.setInt(1, userID);
//			statement = connection.prepareStatement(query2);
//			result = statement.executeQuery(query2);
//			List<JobNotification> jobs = new ArrayList<>();
//			while(result.next()) {
//				int jobId = result.getInt("jid");
//				jobs.add(getJob(jobId));
//			}
		} catch (Exception e) {
			System.out.println("error");
			return user;

		}

		return user;
	}

	public static void main(String[] args) {
		DB db = DB.getInstance();
		db.getUser(1, "123");
		System.out.println();

	}
}
