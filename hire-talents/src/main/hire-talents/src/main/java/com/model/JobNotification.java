package com.model;

public class JobNotification {


	private int jobID;
	private String jobTitle;
	private int numberOfVacancies;
	private String description;
	private String applicationEndDate;
	private HR hr;
	private String skills;

	public JobNotification(int jobID, String jobTitle, String applicationEndDate, String skills, HR hr,
			int numberOfVacancies, String description) {
		super();
		this.jobTitle = jobTitle;
		this.jobID = jobID;
		this.description = description;
		this.hr = hr;
		this.applicationEndDate = applicationEndDate;
		this.numberOfVacancies = numberOfVacancies;
		this.skills = skills;
	}

	public int getJobID() {
		return jobID;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public int getNumberOfVacancies() {
		return numberOfVacancies;
	}

	public String getDescription() {
		return description;
	}

	public String getApplicationEndDate() {
		return applicationEndDate;
	}

	public HR getHr() {
		return hr;
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
