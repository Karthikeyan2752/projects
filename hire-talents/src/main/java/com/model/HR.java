package com.model;

import java.util.ArrayList;
import java.util.List;

public class HR {
	private int id;
	private String companyName;
	private String name;
	private String mobileNumber;
	private String email;
	private String password;
	private List<JobNotification> jobs = new ArrayList<>();

	public String getName() {
		return name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HR(int id, String name, String companyName, String mobileNumber, String email) {
		this.companyName = companyName;
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public void addJobs(JobNotification job) {
		jobs.add(job);
	}

	public List<JobNotification> getJobs() {
		return jobs;
	}

	public String getCompanyName() {
		return companyName;
	}
	@Override
	public String toString() {
		return "id\tname\tcompanyName" + id + "\t" + name + "\t" + companyName + "\n";
	}

}
