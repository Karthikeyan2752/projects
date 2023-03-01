package com.dto;

import java.util.Date;

public class CallLetter {
	private HR hr;
	private User user;
	private JobNotification job;
	private Date date;

	public CallLetter(HR hr, User user, JobNotification job, Date date) {
		super();
		this.hr = hr;
		this.date = date;
		this.user = user;
		this.job = job;
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
