package com.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dto.Admin;
import com.dto.CallLetter;
import com.dto.Credentials;
import com.dto.HR;
import com.dto.JobNotification;
import com.dto.User;

public class DBRepository {

	private static int userID = 1;
	private static int jobID = 1;
	private static int hRUserID = 1;
	private static DBRepository dBRInstance;
	private static Set<User> users = new HashSet<>();
	private static Set<HR> hRs = new HashSet<>();
	private static List<JobNotification> jobs = new ArrayList<>();
	private static List<Credentials> adminCredentials = new ArrayList<Credentials>();
	private Admin admin = null;

	private DBRepository() {

	}

	public User getUser(int userID, String password) {
		for (User user : users) {
			if (user.getUserID() == userID && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public User createAndGetUser(String name, String password, String mobileNumber, List<String> skills) {
		User user = new User(userID++, name, password, mobileNumber, skills);
		users.add(user);
		return user;
	}

	public static DBRepository getInstance() {
		if (dBRInstance == null) {
			dBRInstance = new DBRepository();
			dBRInstance.initialSetup();
		}
		return dBRInstance;
	}

	public Admin checkValidUser(String userName, String password) {
		for (Credentials credential : adminCredentials) {
			if (credential.getUserName().equals(userName) && credential.getPassword().equals(password)) {
				return credential;
			}
		}
		return null;
	}

	private void initialSetup() {
		adminCredentials.add(new Credentials("1", "admin", "123"));
		HR hr = new HR(hRUserID++, "charles", "zoho", "");
		hr.setPassword("123");
		hRs.add(hr);
		HR hr1 = new HR(hRUserID++, "karthi", "reslilient", "");
		hr1.setPassword("111");
		hRs.add(hr1);
		users.add(new User(userID++, "karthi", "123", "9893878738", List.of("sql", "java")));
		JobNotification job = new JobNotification(jobID++, "sde", new Date("02/27/2023"), List.of("sql", "java"), hr,
				2);
		jobs.add(job);
	}

	public HR hRSignin(String name, String companyName, String password, String mobileNumber) {
		HR hr = new HR(hRUserID++, name, companyName, mobileNumber);
		hr.setPassword(password);
		hRs.add(hr);
		return hr;
	}

	public HR hRLogin(int userID, String password) {
		for (HR hr : hRs) {
			if (hr.getId() == userID && hr.getPassword().equals(password)) {
				return hr;
			}
		}
		return null;
	}

	public int postJob(HR hr, String title, int minExperience, int maxExperience, int numberOfVacancies, Date endDate,
			List<String> skills) {
		JobNotification job = new JobNotification(jobID, title, endDate, skills, hr, numberOfVacancies);
		jobs.add(job);
		hr.addJobs(job);
		return jobID++;
	}

	public List<User> getAppliedCandidates(int jobID) {
		for (JobNotification job : jobs) {
			if (job.getID() == jobID) {
				return job.getAppliedCandidates();
			}
		}
		return null;
	}

	public JobNotification getJob(HR hr, int jobID) {
		for(JobNotification job : jobs) {
			if (hr.getId() == job.getHR().getId() && job.getID() == jobID) {
				return job;
			}
		}
		return null;
	}

	public String sendCallLetter(HR hr, List<User> selectedCandidates, JobNotification job, Date interviewDate) {
		for (User candidate : selectedCandidates) {
			CallLetter callLetter = new CallLetter(hr, candidate, job, interviewDate);
			candidate.addCallLetter(callLetter);
		}
		return "call letter sended successfully";
	}

	public List<JobNotification> generateReport(HR hr) {
		return hr.getJobs();
	}

	public List<JobNotification> getJobs() {
		return jobs;
	}

	public String apply(User user, int jobID) {
		String result = "Some thing went wrong!";
		for (JobNotification job : jobs) {
			if (job.getID() == jobID) {
				if (!job.getAppliedCandidates().contains(user)) {
					job.addCandiates(user);
					user.addJobs(job);
					return result = "job with ID : " + jobID + "applied successfully,\nwaiting for HR approval";
				}
			}
		}
		return result;
	}

	public List<JobNotification> getAppliedJobs(User user) {
		return user.getAppliedJobs();
	}

}

