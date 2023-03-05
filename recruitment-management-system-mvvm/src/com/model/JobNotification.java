package com.model;

import java.time.LocalDate;

public class JobNotification {

	private int jobID;
	private String jobTitle;
	private int numberOfVacancies;
	private LocalDate applicationEndDate;
	private HR hr;
	private String skills;

	public JobNotification(int jobID, String jobTitle, LocalDate applicationEndDate, String skills, HR hr,
			int numberOfVacancies) {
		super();
		this.jobTitle = jobTitle;
		this.jobID = jobID;
		this.hr = hr;
		this.numberOfVacancies = numberOfVacancies;
		this.skills = skills;
	}

	public HR getHR() {
		return hr;
	}
	@Override
	public String toString() {
		return "\t" + jobTitle + "\nPosted by : " + hr.getCompanyName() + "\nJob ID : " + jobID
				+ "\nNumber of vacancies : " + numberOfVacancies + "\napplication end date : " + applicationEndDate
				+ "\nRequired skills : " + getSkills() + "\n";
	}

	public String getSkills() {
		return skills;
	}

	public int getID() {
		return jobID;
	}

	public String getName() {
		return jobTitle;
	}

}
