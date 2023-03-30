package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Admin;
import com.model.HR;
import com.model.JobNotification;
import com.model.User;

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



	public JobNotification getJob(int jobID) {
		JobNotification job = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			String query = "select * from job where jid= " + jobID;
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			result.next();
			String title = result.getString("title");
			String dateString = result.getString("endDate");
			LocalDate date = LocalDate.parse(dateString);
			System.out.println(date);
			int noOfVacancies = result.getInt("noOfVacancies");
			int hRID = result.getInt("hrId");
			HR hr = getHR(hRID);
			String skill = result.getString("skill");
			job = new JobNotification(jobID, title, date, skill, hr, noOfVacancies);

		} catch (Exception e) {
			System.out.println("error");
		}

		return job;
	}

	public HR getHR(int hRID) {
		Statement statement = null;
		ResultSet result = null;
		HR hr = null;

		try {
			String query = "select * from hrdetails where id= " + hRID;
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			result.next();
			String name = result.getString("name");
			String companyName = result.getString("companyName");
			String mobile = result.getString("mobile");
			String email = result.getString("email");
			hr = new HR(hRID, name, companyName, mobile, email);
			return hr;
		} catch (SQLException e) {
			System.out.println("error");
		}
		return hr;
	}

	// for login
	public HR getHR(int hRID, String password) {
		Statement statement = null;
		ResultSet result = null;
		HR hr = null;

		try {
			String query = "select * from hrdetails where id= \'" + hRID + "\' and password =\'" + password + "\'";
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			result.next();
			String name = result.getString("name");
			String companyName = result.getString("companyName");
			String mobile = result.getString("mobile");
			String email = result.getString("email");
			hr = new HR(hRID, name, companyName, mobile, email);
			return hr;
		} catch (SQLException e) {
			System.out.println("error");
		}
		return hr;
	}

	// for login
	public User getUser(int userID, String password) {
		Statement statement = null;
		ResultSet result = null;
		User user = null;

		try {
			String query = "select * from users where id= \'" + userID + "\' and password =\'" + password + "\'";
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			result.next();
			String name = result.getString("name");
			String skill = result.getString("skill");
			String mobile = result.getString("mobile");
			String email = result.getString("email");
			String qualification = result.getString("qualification");
			user = new User(userID, name, mobile, skill, qualification);
		} catch (Exception e) {
			System.out.println("error");
			return user;
		}

		return user;
	}

	public User getUser(int userID) {
		Statement statement = null;
		ResultSet result = null;
		User user = null;

		try {
			String query = "select * from users where id= \'" + userID + "\' ";
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			result.next();
			String name = result.getString("name");
			String skill = result.getString("skill");
			String mobile = result.getString("mobile");
			String email = result.getString("email");
			String qualification = result.getString("qualification");
			user = new User(userID, name, mobile, skill, qualification);
		} catch (Exception e) {
			System.out.println("error");
			return user;
		}

		return user;
	}

	public String apply(int userId, int jobId) {
		Statement statement = null;
		try {
			boolean callLetter = false;
			String query = "insert into appliedcandidates values(" + userId + "," + jobId + "," + callLetter + ")";
			statement = connection.createStatement();
			statement.executeUpdate(query);
			return "job with ID : " + jobId + " applied successfully";
		} catch (SQLException e) {
			System.out.println("error");
		}
		return "somwthing went wrong\n";
	}

	public List<JobNotification> getJobs() {
		List<JobNotification> jobs = new ArrayList<>();
		JobNotification job = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			String query = "select * from job";
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				int jobID = result.getInt("jid");
				String title = result.getString("title");
				String dateString = result.getString("endDate");
				LocalDate date = LocalDate.parse(dateString);
				System.out.println(date);
				int noOfVacancies = result.getInt("noOfVacancies");
				int hRID = result.getInt("hrId");
				HR hr = getHR(hRID);
				String skill = result.getString("skill");
				job = new JobNotification(jobID, title, date, skill, hr, noOfVacancies);
				jobs.add(job);
			}
		} catch (SQLException e) {
			System.out.println("error");
		}
		return jobs;
	}

	public List<JobNotification> getJobs(int hrId) {
		List<JobNotification> jobs = new ArrayList<>();
		JobNotification job = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			String query = "select * from job where hrId=" + hrId;
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				int jobID = result.getInt("jid");
				String title = result.getString("title");
				String dateString = result.getString("endDate");
				LocalDate date = LocalDate.parse(dateString);
				System.out.println(date);
				int noOfVacancies = result.getInt("noOfVacancies");
				int hRID = result.getInt("hrId");
				HR hr = getHR(hRID);
				String skill = result.getString("skill");
				job = new JobNotification(jobID, title, date, skill, hr, noOfVacancies);
				jobs.add(job);
			}
		} catch (SQLException e) {
			System.out.println("error");
		}
		return jobs;
	}

	public List<User> getAppliedCandidates(int jobId) {
		Statement statement = null;
		ResultSet result = null;
		List<User> appliedCandidates = new ArrayList<>();
		try {
			String query = "select*from appliedcandidates where jid="+jobId;
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				int userId = result.getInt("uid");
				User user = getUser(userId);
				appliedCandidates.add(user);
			}
		} catch (SQLException e) {
			System.out.println("error");
		}
		return appliedCandidates;
	}
	
	public List<JobNotification> getAppliedJobs(int userId) {

		List<JobNotification> appliedJobs = new ArrayList<>();
		Statement statement = null;
		ResultSet result = null;

		try {
			String query = "select jid from appliedcandidates where uid=" + userId;
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				int jobId = result.getInt("jid");
				JobNotification job = getJob(jobId);
				appliedJobs.add(job);
			}
		} catch (SQLException e) {
			System.out.println("error");
		}
		return appliedJobs;
	}
	public String sendCallLetter(int userId, int jobId) {
		Statement statement  = null;
		try {
			boolean callLetter = true;
			String query = "UPDATE appliedcandidates SET isCallLetterSent=" + callLetter + " WHERE jid=" + jobId
					+ " AND uid=" + userId;
			statement = connection.createStatement();
			statement.execute(query);
			return "call letter sent successfully";
		}catch(SQLException e) {
			System.out.println("Error");
		}
		return "something went wrong\n";
	}

	public List<JobNotification> getCallLetters(int userId) {
		List<JobNotification> callLetters = new ArrayList<>();
		Statement statement = null;
		ResultSet result = null;
		try {
			boolean i = true;
			String query = "SELECT * FROM appliedcandidates WHERE uid=" + userId + " AND isCallLetterSent=" + i;
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				int jobId = result.getInt("jid");
				System.out.println(jobId);
				JobNotification job = getJob(jobId);
				callLetters.add(job);
			}
		} catch (SQLException e) {
			System.out.println("error");
		}
		return callLetters;
		
	}

	public int postJob(HR hr, String title, int numberOfVacancies, LocalDate interviewDate,
			String skills) {
		PreparedStatement ps = null;
		ResultSet result = null;
		int jobId = 0;
		String query = "SELECT MAX(jid) AS max_jid FROM job";
		try {
			ps = connection.prepareStatement(query);
			result = ps.executeQuery();
			if (result.next()) {
				jobId = result.getInt("max_jid");
			}
			query = "INSERT INTO job VALUES (?, ?, ?, ?, ?, ?)";
			ps = connection.prepareStatement(query);
			ps.setInt(1, ++jobId);
			ps.setString(2, title);
			ps.setInt(3, numberOfVacancies);
			ps.setString(4, skills);
			ps.setInt(5, hr.getId());
			ps.setObject(6, interviewDate);
			ps.executeUpdate();
			return jobId;
		} catch (SQLException e) {
			System.out.println("error");
		}
		return jobId;
	}

	public User createAndGetUser(String name, String email, String qualification, String password, String mobileNumber,
			String skills) {
		User user = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "SELECT MAX(id) AS max_uid FROM users";
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			int userId = 0;
			if (result.next()) {
				userId = result.getInt("max_uid");
			}
			query = "INSERT INTO users VALUES (" + ++userId + ", '" + name + "', '" + password + "', '" + mobileNumber
					+ "', '" + email + "', '" + qualification + "', '" + skills + "')";
			statement.executeUpdate(query);
			user = new User(userId, name, mobileNumber, skills, qualification);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public HR hRSignin(String name, String email, String companyName, String password, String mobileNumber) {
		HR hr = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "SELECT MAX(id) AS max_hrid FROM hrdetails";
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			int userId = 0;
			if (result.next()) {
				userId = result.getInt("max_hrid");
			}
			query = "INSERT INTO hrdetails VALUES (" + ++userId + ", '" + name + "', '" + password + "', '"
					+ mobileNumber + "', '" + email + "', '" + companyName + "')";
			statement.executeUpdate(query);
			hr = new HR(userId, name, companyName, mobileNumber, email);
			hr.setPassword(password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hr;

	}

	public Admin checkValidUser(String userName, String password) {
		return null;
	}

}
