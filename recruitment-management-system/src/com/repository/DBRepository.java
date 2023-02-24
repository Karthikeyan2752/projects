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
	private Set<User> users = new HashSet<>();
	private Set<HR> hRs = new HashSet<>();
	private List<JobNotification> jobs = new ArrayList<>();
	private List<Credentials> adminCredentials = new ArrayList<Credentials>();
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

	public User createAndGetUser(String name, String password, long mobileNumber, List<String> skills) {
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
	}

	public HR hRSignin(String name, String companyName, String password, long mobileNumber) {
		HR hr = new HR(hRUserID++, name, companyName, mobileNumber);
		hr.setPassword(password);
		hRs.add(hr);
		return hr;
	}

	public HR hRLogin(int userID, String password) {
		for (HR hr : hRs) {
			if (hr.getId() == userID) {
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

}

