package com.dto;

import java.util.ArrayList;
import java.util.List;

public class HR {
	private int id;
	private String companyName;
	private String name;
	private long mobileNumber;
	private String password;
	private List<JobNotification> jobs = new ArrayList<>();

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

	public HR(int id, String name, String companyName, long mobileNumber) {
		this.companyName = companyName;
		this.name = name;
		this.mobileNumber = mobileNumber;
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
		return id + "\t" + name + "\t" + companyName;
	}

}
