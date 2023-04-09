package com.model;

public class CallLetter {
	private HR hr;
	private User user;
	private JobNotification job;
	private String date;
	private String venue;
	private String time;

	public CallLetter(HR hr, User user, JobNotification job, String date, String venue, String time) {
		super();
		this.hr = hr;
		this.venue = venue;
		this.date = date;
		this.user = user;
		this.job = job;
		this.time = time;
	}

	public HR getHr() {
		return hr;
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
	@Override
	public String toString() {
		return "-----------------------" + hr.getCompanyName() + "-----------------------\n|\n"
				+ "| Interview Date: \n| " + date + "\n| From : \n| HR of " + hr.getCompanyName() + "\n| To : \n| "
				+ user.getName() + "\n| For :\n| " + job.getName() + "\n|\tKindly bring your resume\n| "
				+ "\n|\t   -regards\n|\t\t" + hr.getName()
				+ "\n----------------------------------------------------------------";
	}

}
