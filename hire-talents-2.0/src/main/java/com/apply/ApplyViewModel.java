package com.apply;

import java.util.List;

import com.model.CallLetter;
import com.model.JobNotification;
import com.model.User;
import com.repository.DB;

public class ApplyViewModel {



	public String apply(User user, int jobID) {
		return DB.getInstance().apply(user.getUserID(), jobID);
	}


	public List<JobNotification> getAppliedJobs(User user) {
		return DB.getInstance().getAppliedJobs(user.getUserID());
	}


	public List<CallLetter> getCallLetters(int userID, int start) {
		return DB.getInstance().fetchCallLetters(start, userID);
	}

	public String report(int userID, String issue, String description) {
		return DB.getInstance().report(userID, issue, description);
	}

	public String feedback(int userID, String feedback) {
		return DB.getInstance().feedback(userID, feedback);
	}

	public String updateUser(int userID, String name, String mobileNumber, String skills, String qualification,
			int experience, String location, String about) {
		return DB.getInstance().updateUser(userID, name, mobileNumber, skills, qualification, experience, location,
				about);
	}

}
