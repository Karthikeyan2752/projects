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
		return "Interview Date: \n" + date + "\nFrom : \n" + hr.getCompanyName() + "\nTo : \n" + user.toString()
				+ "\nFor :\n"
				+ job.toString();
	}

}
