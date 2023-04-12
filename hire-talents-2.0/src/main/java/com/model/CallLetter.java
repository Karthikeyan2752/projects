package com.model;

public class CallLetter {

	private User user;
	private JobNotification job;
	private String date;
	private String venue;
	private String time;

	public CallLetter() {
		// TODO Auto-generated constructor stub
	}

	public CallLetter(User user, JobNotification job, String date, String venue, String time) {
		super();
		this.venue = venue;
		this.date = date;
		this.user = user;
		this.job = job;
		this.time = time;
	}

	public HR getHr() {
		return job.getHr();
	}

	public User getUser() {
		return user;
	}

	public JobNotification getJob() {
		return job;
	}

	public String getDate() {
		return date;
	}

	public String getVenue() {
		return venue;
	}

	public String getTime() {
		return time;
	}

}
