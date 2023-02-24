package com.dto;

import java.util.Date;
import java.util.List;

public class JobNotification {

	private String jobTitle;
	private int numberOfVacancies;
	private Date applicationEndDate;
	private String companyName;
	private List<String> skills;
	private List<User> appliedCandidates;

	public JobNotification(String jobTitle, Date applicationEndDate, String companyName, List<String> skills,
			int numberOfVacancies) {
		super();
		this.jobTitle = jobTitle;
		this.numberOfVacancies = numberOfVacancies;
		this.applicationEndDate = applicationEndDate;
		this.companyName = companyName;
		this.skills = skills;
	}

}
