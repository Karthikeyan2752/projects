package com.model;

public class JobNotification {

	private int jobID;
	private String jobTitle;
	private int numberOfVacancies;
	private String description;
	private HR hr;
	private String skills;
	private int experience;
	private String responsibilities;
	private String location;
	private int type;
	private String requirements;
	private boolean isActive;

	public JobNotification(int jobID, String jobTitle, String skills, HR hr,
			int numberOfVacancies, String description, int experience, String responsibilities, String location,
			int type, String requirements, boolean isActive) {
		super();
		this.experience = experience;
		this.responsibilities = responsibilities;
		this.requirements = requirements;
		this.isActive = isActive;
		this.location = location;
		this.type = type;
		this.jobTitle = jobTitle;
		this.jobID = jobID;
		this.description = description;
		this.hr = hr;
		this.numberOfVacancies = numberOfVacancies;
		this.skills = skills;
	}

	public int getExperience() {
		return experience;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public String getLocation() {
		return location;
	}

	public String getType() {
		if (type == 1) {
			return "WFH";
		} else if (type == 2) {
			return "WFO";
		} else if (type == 3) {
			return "Remote";
		}
		return "Not specified";
	}

	public String getRequirements() {
		return requirements;
	}

	public boolean isActive() {
		return isActive;
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

	public HR getHr() {
		return hr;
	}

	public HR getHR() {
		return hr;
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
