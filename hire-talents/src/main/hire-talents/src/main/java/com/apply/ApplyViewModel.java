package com.apply;

import java.util.List;

import com.model.JobNotification;
import com.model.User;
import com.repository.DB;

public class ApplyViewModel {


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

	public String report(int userID, String issue, String description) {
		return DB.getInstance().report(userID, issue, description);
	}

	public String feedback(int userID, String feedback) {
		return DB.getInstance().feedback(userID, feedback);
	}

}
