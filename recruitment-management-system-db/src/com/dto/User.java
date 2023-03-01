package com.dto;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int userID;
	private String name;
	private String password;
	private String mobileNumber;
	private List<CallLetter> callLetters = new ArrayList<>();
	private List<JobNotification> appliedJobs = new ArrayList<>();
	private List<String> skills = new ArrayList<>();

	public User(int userID, String name, String password, String mobileNumber, List<String> skills) {
		this.skills = skills;
		this.name = name;
		this.userID = userID;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}

	public List<JobNotification> getAppliedJobs() {
		return appliedJobs;
	}

	public void addJobs(JobNotification job) {
		appliedJobs.add(job);
	}

	public int getUserID() {
		return userID;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void addCallLetter(CallLetter callLetter) {
		callLetters.add(callLetter);
	}

	public List<CallLetter> getCallLetter() {
		return callLetters;
	}

	@Override
	public String toString() {
		return "user id : " + userID + "\nname : " + name + "\nmobile : " + mobileNumber + "\n";
	}

	public List<String> getSkills() {
		return skills;
	}

}
