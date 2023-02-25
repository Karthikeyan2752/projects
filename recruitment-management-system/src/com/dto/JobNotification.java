package com.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobNotification {

	private int jobID;
	private String jobTitle;
	private int numberOfVacancies;
	private Date applicationEndDate;
	private HR hr;
	private List<String> skills = new ArrayList<>();
	private List<User> appliedCandidates = new ArrayList<>();

	public JobNotification(int jobID, String jobTitle, Date applicationEndDate, List<String> skills, HR hr,
			int numberOfVacancies) {
		super();
		this.jobTitle = jobTitle;
		this.jobID = jobID;
		this.numberOfVacancies = numberOfVacancies;
		this.applicationEndDate = applicationEndDate;
		this.hr = hr;
		this.skills = skills;
	}

	public void addCandiates(User user) {
		appliedCandidates.add(user);
	}

	@Override
	public String toString() {
		return "\t" + jobTitle + "\nPosted by : " + hr.getCompanyName() + "\nJob ID : " + jobID
				+ "\nNumber of vacancies : " + numberOfVacancies + "\napplication end date : " + applicationEndDate
				+ "\nRequired skills : " + getSkillString() + "\nTotal applicants : " + appliedCandidates.size();
	}

	private String getSkillString() {
		String skillSet = "";
		for (String skill : skills) {
			skillSet += skill + " ";
		}
		return skillSet;
	}

	public List<User> getAppliedCandidates() {
		return appliedCandidates;
	}

	public int getID() {
		return jobID;
	}

	public HR getHR() {
		return hr;
	}

	public List<String> getSkills() {
		return skills;
	}


}
