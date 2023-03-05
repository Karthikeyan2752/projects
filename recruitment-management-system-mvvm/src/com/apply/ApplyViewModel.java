package com.apply;

import java.util.List;

import com.model.JobNotification;
import com.model.User;
import com.repository.DB;

public class ApplyViewModel {

	private ApplyView applyView;

	public ApplyViewModel(ApplyView applyView) {
		this.applyView = applyView;
	}


	public List<JobNotification> getJobs() {
		return DB.getInstance().getJobs();
	}


	public String apply(User user, int jobID) {
		return DB.getInstance().apply(user.getUserID(), jobID);
	}


	public List<JobNotification> getAppliedJobs(User user) {
		return DB.getInstance().getAppliedJobs(user.getUserID());
	}


	public List<JobNotification> getCallLetters(User user) {
		return DB.getInstance().getCallLetters(user.getUserID());
	}

}
