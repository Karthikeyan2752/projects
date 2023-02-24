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
		return "Interview Date: \n" + date + "From : \n" + hr.toString() + "To : \n" + user.toString() + "For :\n"
				+ job.toString();
	}

}
