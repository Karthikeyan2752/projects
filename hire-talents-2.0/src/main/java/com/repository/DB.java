package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.CallLetter;
import com.model.HR;
import com.model.JobNotification;
import com.model.User;

public class DB {

	public static DB dBRInstance;
	private static Connection connection;

	private DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rms2", "root", "Karthikn2752");
		} catch (ClassNotFoundException | SQLException e) {
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
			int noOfVacancies = result.getInt("noOfVacancies");
			int hRID = result.getInt("hrId");
			HR hr = getHR(hRID);
			String skill = result.getString("skill");
			String description = result.getString("description");
			int experience = result.getInt("experience");
			String responsibilities = result.getString("responsibilities");
			String location = result.getString("location");
			String requirements = result.getString("requirements");
			boolean isActive = result.getBoolean("isActive");
			String type = result.getString("type");

			job = new JobNotification(jobID, title, skill, hr, noOfVacancies, description, experience, responsibilities,
					location, type, requirements, isActive);

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
			String location = result.getString("location");
			String about = result.getString("about");
			String websiteURL = result.getString("website");
			hr = new HR(hRID, name, companyName, mobile, email, about, location, websiteURL);
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
			String location = result.getString("location");
			String about = result.getString("about");
			String websiteURL = result.getString("website");
			hr = new HR(hRID, name, companyName, mobile, email, about, location, websiteURL);
			return hr;
		} catch (SQLException e) {
			System.out.println("error");
		}
		return hr;
	}

	// for login
	public User getUser(String email, String password) {
		Statement statement = null;
		ResultSet result = null;
		User user = null;

		try {
			String query = "select * from users where email= \'" + email + "\' and password =\'" + password + "\'";
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			result.next();
			String name = result.getString("name");
			String skill = result.getString("skill");
			String mobile = result.getString("mobile");
			String qualification = result.getString("qualification");
			int userID = result.getInt("id");
			int experience = result.getInt("experience");
			String location = result.getString("location");
			String about = result.getString("about");
			user = new User(userID, name, mobile, skill, qualification, email, experience, location, about);
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
			int experience = result.getInt("experience");
			String location = result.getString("location");
			String about = result.getString("about");
			user = new User(userID, name, mobile, skill, qualification, email, experience, location, about);
		} catch (Exception e) {
			System.out.println("error");
			return user;
		}

		return user;
	}

	public List<JobNotification> fetchJobsFromDatabase(int start, int userID) {
		List<JobNotification> jobs = new ArrayList<>();
		JobNotification job = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String query = "SELECT * FROM job WHERE jid NOT IN (SELECT jid FROM appliedcandidates WHERE uid = ?) AND isActive=? ORDER BY jid LIMIT ?, ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, userID);
			statement.setBoolean(2, true);
			statement.setInt(3, start);
			statement.setInt(4, 10);
			result = statement.executeQuery();

			while (result.next()) {
				int jobID = result.getInt("jid");
				String title = result.getString("title");
				int noOfVacancies = result.getInt("noOfVacancies");
				int hrID = result.getInt("hrId");
				HR hr = getHR(hrID);
				String skills = result.getString("skill");
				String description = result.getString("description");
				int experience = result.getInt("experience");
				String responsibilities = result.getString("responsibilities");
				String location = result.getString("location");
				String requirements = result.getString("requirements");
				boolean isActive = result.getBoolean("isActive");
				String type = result.getString("type");

				job = new JobNotification(jobID, title, skills, hr, noOfVacancies, description, experience,
						responsibilities, location, type, requirements, isActive);
				jobs.add(job);
			}
			System.out.println(jobs.size());
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return jobs;
	}

	public String apply(int userId, int jobId) {
		PreparedStatement preparedStatement = null;
		try {
			boolean callLetter = false;
			String s = "";
			String query = "INSERT INTO appliedcandidates VALUES(?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, jobId);
			preparedStatement.setBoolean(3, callLetter);
			preparedStatement.setString(4, s);
			preparedStatement.setString(5, s);
			preparedStatement.setString(6, s);
			preparedStatement.executeUpdate();
			return "Job with ID: " + jobId + " applied successfully";
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		return "Something went wrong.\n";
	}

	public List<JobNotification> getJobsUserNotApplied(int userId) {
		List<JobNotification> jobs = new ArrayList<>();
		JobNotification job = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {

			String query2 = "SELECT * FROM job WHERE jid NOT IN (SELECT jid FROM appliedcandidates WHERE uid = ?) AND isActive=?";
			statement = connection.prepareStatement(query2);
			statement.setInt(1, userId);
			statement.setBoolean(2, true);
			result = statement.executeQuery();
			while (result.next()) {
				int jobID = result.getInt("jid");
				String title = result.getString("title");
				int noOfVacancies = result.getInt("noOfVacancies");
				int hRID = result.getInt("hrId");
				HR hr = getHR(hRID);
				String skill = result.getString("skill");
				String description = result.getString("description");
				int experience = result.getInt("experience");
				String responsibilities = result.getString("responsibilities");
				String location = result.getString("location");
				String requirements = result.getString("requirements");
				boolean isActive = result.getBoolean("isActive");
				String type = result.getString("type");

				job = new JobNotification(jobID, title, skill, hr, noOfVacancies, description, experience,
						responsibilities, location, type, requirements, isActive);
				jobs.add(job);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return jobs;
	}

	public boolean isEmailInUsers(String email) {
		Statement statement = null;
		ResultSet result = null;
		try {
			String query = "select * from users where email=" + email;
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			return result.next();
		} catch (SQLException e) {
			System.out.println("error");
		}
		return false;
	}

	public boolean isEmailInHrDetails(String email) {
		Statement statement = null;
		ResultSet result = null;
		try {
			String query = "select * from hrdetails where email=" + email;
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			return result.next();
		} catch (SQLException e) {
			System.out.println("error");
		}
		return false;
	}

	public List<User> getAppliedCandidates(int start, int jobId) {
		PreparedStatement statement = null;
		ResultSet result = null;
		List<User> appliedCandidates = new ArrayList<>();
		try {

			String query = "SELECT uid FROM appliedcandidates WHERE jid=? AND isCallLetterSent=? ORDER BY jid LIMIT ?, ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, jobId);
			statement.setBoolean(2, false);
			statement.setInt(3, start);
			statement.setInt(4, 10);
			result = statement.executeQuery();
			while (result.next()) {
				int userId = result.getInt("uid");
				User user = getUser(userId);
				appliedCandidates.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return appliedCandidates;
	}

	public List<User> getAppliedCandidates(int jobId) {
		PreparedStatement statement = null;
		ResultSet result = null;
		List<User> appliedCandidates = new ArrayList<>();
		try {

			String query = "SELECT uid FROM appliedcandidates WHERE jid=? AND isCallLetterSent=? ";
			statement = connection.prepareStatement(query);
			statement.setInt(1, jobId);
			statement.setBoolean(2, false);
			result = statement.executeQuery();
			while (result.next()) {
				int userId = result.getInt("uid");
				User user = getUser(userId);
				appliedCandidates.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

	public String sendCallLetter(int userId, int jobId, String venue, String date, String time) {
		PreparedStatement preparedStatement = null;
		try {
			boolean callLetter = true;

			String query = "UPDATE appliedcandidates SET isCallLetterSent=?, date=?, time=?, venue=? WHERE jid=? AND uid=?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setBoolean(1, callLetter);
			preparedStatement.setString(2, date);
			preparedStatement.setString(3, time);
			preparedStatement.setString(4, venue);
			preparedStatement.setInt(5, jobId);
			preparedStatement.setInt(6, userId);
			preparedStatement.executeUpdate();
			return "call letter sent successfully";
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
		}
		return "something went wrong\n";
	}

	public int postJob(int HRID, String title, int numberOfVacancies, String skills, String description,
			String requirements, String responsibilities, int experience, String type, String location) {
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
			query = "INSERT INTO job VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = connection.prepareStatement(query);
			ps.setInt(1, ++jobId);
			ps.setString(2, title);
			ps.setInt(3, numberOfVacancies);
			ps.setString(4, skills);
			ps.setInt(5, HRID);
			ps.setString(6, description);
			ps.setInt(7, experience);
			ps.setString(8, responsibilities);
			ps.setString(9, location);
			ps.setString(10, type);
			ps.setString(11, requirements);
			ps.setBoolean(12, true);
			ps.executeUpdate();
			return jobId;
		} catch (SQLException e) {
			System.out.println("error");
		}
		return jobId;
	}

	public User createAndGetUser(String name, String email, String qualification, String password, String mobileNumber,
			String skills, int experience, String location, String about) {
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
					+ "', '" + email + "', '" + qualification + "', '" + skills + "','" + experience + "','" + location
					+ "','" + about + "')";
			statement.executeUpdate(query);
			user = new User(userId, name, mobileNumber, skills, qualification, email, experience, location, about);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public HR hRSignin(String name, String email, String companyName, String password, String mobileNumber,
			String about, String location, String websiteURL) {
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
					+ mobileNumber + "', '" + email + "', '" + companyName + "','" + location + "','" + about + "','"
					+ websiteURL + "')";
			statement.executeUpdate(query);
			hr = new HR(userId, name, companyName, mobileNumber, email, about, location, websiteURL);
			hr.setPassword(password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hr;

	}

	public String deactivateJob(int jobID) {
		try {
			String query = "UPDATE job SET isActive=? where jid=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setBoolean(1, false);
			statement.setInt(2, jobID);
			int result = statement.executeUpdate();
			if (result > 0) {
				return "Deactivated successfully";
			} else {
				return "Deactivation failed";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Deactivation failed";
	}

	public String updateUser(int userID, String name, String mobileNumber, String skills, String qualification,
			int experience, String location, String about) {
		try {
			String sql = "UPDATE users SET name=?, mobile=?, skill=?, qualification=?,  experience=?,location=?,about=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, mobileNumber);
			statement.setString(3, skills);
			statement.setString(4, qualification);
			statement.setInt(5, experience);
			statement.setString(6, location);
			statement.setString(7, about);
			statement.setInt(8, userID);
			int result = statement.executeUpdate();
			if (result > 0) {
				return "updation successfull";
			} else {
				return "updation failure";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "updation failure";
	}

	public String updateHR(int userID, String name, String mobileNumber, String website, String companyName,
			String location, String about) {
		try {
			String sql = "UPDATE hrdetails SET name=?, mobile=?, website=?, companyName=?, location=?,about=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, mobileNumber);
			statement.setString(3, website);
			statement.setString(4, companyName);
			statement.setString(5, location);
			statement.setString(6, about);
			statement.setInt(7, userID);
			int result = statement.executeUpdate();
			if (result > 0) {
				return "updation successfull";
			} else {
				return "updation failure";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "updation failure";
	}

	public String removeCandidate(int userID, int jobID) {
		try {
			String query = "DELETE FROM appliedcandidates WHERE uid = " + userID + " AND jid = " + jobID + ";";
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			if (result > 0) {
				return "candidate removed successfully";
			} else {
				return "candidate not removed";
			}
		} catch (SQLException e) {
			return "Error while deleting record: " + e.getMessage();
		}
	}

	public int getNoOfSelectedCandidates(int jobID) {
		PreparedStatement statement = null;
		ResultSet result = null;
		String query = "SELECT count(uid) from appliedcandidates where jid = ? and isCallLetterSent = ?";
		int count = 0;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, jobID);
			statement.setBoolean(2, true);
			result = statement.executeQuery();
			if (result.next()) {
				count = result.getInt(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public String report(int userID, String issue, String description) {
		PreparedStatement statement = null;
		String query = "insert into reports values(?,?,?)";
		boolean result = false;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, userID);
			statement.setString(2, issue);
			statement.setString(3, description);
			result = statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result + "";
	}

	public String feedback(int userID, String feedback) {
		PreparedStatement statement = null;
		String query = "insert into feedback values(?,?)";
		boolean result = false;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, userID);
			statement.setString(2, feedback);
			result = statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result + "";
	}

	public int getNoOfAppliedCandidates(int jobID) {
		PreparedStatement statement = null;
		ResultSet result = null;
		String query = "SELECT count(uid) from appliedcandidates where jid = ?";
		int count = 0;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, jobID);
			result = statement.executeQuery();
			if (result.next()) {
				count = result.getInt(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getAppliedJobsCount(int userID) {
		PreparedStatement statement = null;
		ResultSet result = null;
		String query = "SELECT count(jid) from appliedcandidates where uid = ?";
		int count = 0;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, userID);
			result = statement.executeQuery();
			if (result.next()) {
				count = result.getInt(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getSelectedJobsCount(int userID) {
		PreparedStatement statement = null;
		ResultSet result = null;
		String query = "SELECT count(jid) from appliedcandidates where uid = ? and isCallLetterSent= ?";
		int count = 0;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, userID);
			statement.setBoolean(2, true);
			result = statement.executeQuery();
			if (result.next()) {
				count = result.getInt(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<JobNotification> fetchJobsFromDatabaseWithName(int start, int userID, String title) {
		List<JobNotification> jobs = new ArrayList<>();
		JobNotification job = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String query = "SELECT * FROM job WHERE title LIKE CONCAT('%', ?, '%') AND jid NOT IN (SELECT jid FROM appliedcandidates WHERE uid = ?) ORDER BY jid LIMIT ?, ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, title);
			statement.setInt(2, userID);
			statement.setInt(3, start);
			statement.setInt(4, 10);
			result = statement.executeQuery();

			while (result.next()) {
				int jobID = result.getInt("jid");
				String name = result.getString("title");
				int noOfVacancies = result.getInt("noOfVacancies");
				int hrID = result.getInt("hrId");
				HR hr = getHR(hrID);
				String skills = result.getString("skill");
				String description = result.getString("description");
				int experience = result.getInt("experience");
				String responsibilities = result.getString("responsibilities");
				String location = result.getString("location");
				String requirements = result.getString("requirements");
				boolean isActive = result.getBoolean("isActive");
				String type = result.getString("type");

				job = new JobNotification(jobID, name, skills, hr, noOfVacancies, description, experience,
						responsibilities, location, type, requirements, isActive);
				jobs.add(job);
			}
			System.out.println(jobs.size());
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return jobs;
	}

	public List<JobNotification> fetchAppliedJobs(int start, int userID) {
		List<JobNotification> jobs = new ArrayList<>();
		JobNotification job = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String query = "SELECT * FROM job WHERE jid IN (SELECT jid FROM appliedcandidates WHERE uid = ?) ORDER BY jid LIMIT ?, ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, userID);
			statement.setInt(2, start);
			statement.setInt(3, 10);
			result = statement.executeQuery();

			while (result.next()) {
				int jobID = result.getInt("jid");
				String title = result.getString("title");
				int noOfVacancies = result.getInt("noOfVacancies");
				int hrID = result.getInt("hrId");
				HR hr = getHR(hrID);
				String skills = result.getString("skill");
				String description = result.getString("description");
				int experience = result.getInt("experience");
				String responsibilities = result.getString("responsibilities");
				String location = result.getString("location");
				String requirements = result.getString("requirements");
				boolean isActive = result.getBoolean("isActive");
				String type = result.getString("type");

				job = new JobNotification(jobID, title, skills, hr, noOfVacancies, description, experience,
						responsibilities, location, type, requirements, isActive);
				jobs.add(job);
			}
			System.out.println(jobs.size());
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return jobs;
	}

	public List<CallLetter> fetchCallLetters(int start, int userID) {
		List<CallLetter> callLetters = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String query = "SELECT * FROM appliedcandidates WHERE uid=? and isCallLetterSent = ? ORDER BY uid LIMIT ?, ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, userID);
			statement.setBoolean(2, true);
			statement.setInt(3, start);
			statement.setInt(4, 10);
			result = statement.executeQuery();

			while (result.next()) {
				int jobID = result.getInt("jid");
				User user = getUser(userID);
				JobNotification job = getJob(jobID);
				String venue = result.getString("venue");
				String date = result.getString("date");
				String time = result.getString("time");
				CallLetter callLetter = new CallLetter(user, job, date, venue, time);
				callLetters.add(callLetter);
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println(callLetters.size() + "sizeee");
		return callLetters;

	}

	public HR getHR(String email, String password) {
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		HR hr = null;

		try {
			String query = "SELECT * FROM hrdetails WHERE email = ? AND password = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeQuery();
			if (result.next()) {
				String name = result.getString("name");
				int id = result.getInt("id");
				String companyName = result.getString("companyName");
				String mobile = result.getString("mobile");
				String location = result.getString("location");
				String about = result.getString("about");
				String websiteURL = result.getString("website");
				hr = new HR(id, name, companyName, mobile, email, about, location, websiteURL);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (result != null) {
					result.close();
				}
			} catch (SQLException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		return hr;
	}

	public int getPostedJobsCount(int hRID) {
		PreparedStatement statement = null;
		ResultSet result = null;
		String query = "select count(jid) from job where hrId=?";
		int count = 0;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, hRID);
			result = statement.executeQuery();
			if (result.next()) {
				count = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getSelectedCandidatesCount(int hRID) {
		PreparedStatement statement = null;
		ResultSet result = null;
		String query = "SELECT COUNT(jid) FROM appliedcandidates WHERE isCallLetterSent = ? AND jid IN (SELECT jid FROM job WHERE hrId = ?)";
		int count = 0;
		try {
			statement = connection.prepareStatement(query);
			statement.setBoolean(1, true);
			statement.setInt(2, hRID);
			result = statement.executeQuery();
			if (result.next()) {
				count = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;

	}

	public List<JobNotification> fetchPostedJobsFromDatabase(int start, int userID) {
		List<JobNotification> jobs = new ArrayList<>();
		JobNotification job = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String query = "SELECT * FROM job WHERE jid IN (SELECT jid FROM job WHERE hrId = ?) ORDER BY jid LIMIT ?, ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, userID);
			statement.setInt(2, start);
			statement.setInt(3, 10);
			result = statement.executeQuery();

			while (result.next()) {
				int jobID = result.getInt("jid");
				String title = result.getString("title");
				int noOfVacancies = result.getInt("noOfVacancies");
				int hrID = result.getInt("hrId");
				HR hr = getHR(hrID);
				String skills = result.getString("skill");
				String description = result.getString("description");
				int experience = result.getInt("experience");
				String responsibilities = result.getString("responsibilities");
				String location = result.getString("location");
				String requirements = result.getString("requirements");
				boolean isActive = result.getBoolean("isActive");
				String type = result.getString("type");

				job = new JobNotification(jobID, title, skills, hr, noOfVacancies, description, experience,
						responsibilities, location, type, requirements, isActive);
				jobs.add(job);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return jobs;
	}

	public List<JobNotification> getJobsPostedByHR(int HRID) {
		List<JobNotification> jobs = new ArrayList<>();
		JobNotification job = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String query = "SELECT * FROM job WHERE hrId=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, HRID);
			result = statement.executeQuery();

			while (result.next()) {
				int jobID = result.getInt("jid");
				String title = result.getString("title");
				int noOfVacancies = result.getInt("noOfVacancies");
				HR hr = getHR(HRID);
				String skills = result.getString("skill");
				String description = result.getString("description");
				int experience = result.getInt("experience");
				String responsibilities = result.getString("responsibilities");
				String location = result.getString("location");
				String requirements = result.getString("requirements");
				boolean isActive = result.getBoolean("isActive");
				String type = result.getString("type");

				job = new JobNotification(jobID, title, skills, hr, noOfVacancies, description, experience,
						responsibilities, location, type, requirements, isActive);
				jobs.add(job);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return jobs;
	}

	public List<JobNotification> fetchFromPostedJobs(int start, int userID, String title) {
		List<JobNotification> jobs = new ArrayList<>();
		JobNotification job = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String query = "SELECT * FROM job WHERE title LIKE CONCAT('%', ?, '%') AND jid IN (SELECT jid FROM job WHERE hrId = ?) ORDER BY jid LIMIT ?, ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, title);
			statement.setInt(2, userID);
			statement.setInt(3, start);
			statement.setInt(4, 10);
			result = statement.executeQuery();

			while (result.next()) {
				int jobID = result.getInt("jid");
				String name = result.getString("title");
				int noOfVacancies = result.getInt("noOfVacancies");
				int hrID = result.getInt("hrId");
				HR hr = getHR(hrID);
				String skills = result.getString("skill");
				String description = result.getString("description");
				int experience = result.getInt("experience");
				String responsibilities = result.getString("responsibilities");
				String location = result.getString("location");
				String requirements = result.getString("requirements");
				boolean isActive = result.getBoolean("isActive");
				String type = result.getString("type");

				job = new JobNotification(jobID, name, skills, hr, noOfVacancies, description, experience,
						responsibilities, location, type, requirements, isActive);
				jobs.add(job);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return jobs;
	}

}
