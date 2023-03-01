package com.apply;

import java.util.List;

import com.dto.JobNotification;
import com.dto.User;
import com.repository.DB;

public class ApplyModel implements ApplyModelCallBack {

	private ApplyControllerCallBack applyController;

	public ApplyModel(ApplyController applyController) {
		this.applyController = applyController;
	}

	@Override
	public List<JobNotification> getJobs() {
		return DB.getInstance().getJobs();
	}

	@Override
	public String apply(User user, int jobID) {
		return DB.getInstance().apply(user.getUserID(), jobID);
	}

	@Override
	public List<JobNotification> getAppliedJobs(User user) {
		return DB.getInstance().getAppliedJobs(user.getUserID());
	}

	@Override
	public List<JobNotification> getCallLetters(User user) {
		return DB.getInstance().getCallLetters(user.getUserID());
	}

}
