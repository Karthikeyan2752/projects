package com.apply;

import java.util.List;

import com.dto.JobNotification;
import com.dto.User;

public class ApplyController implements ApplyControllerCallBack {

	private ApplyModelCallBack applyModel;

	public ApplyController(ApplyViewCallBack applyView) {
		this.applyModel = new ApplyModel(this);
	}

	@Override
	public List<JobNotification> getJobs() {
		return applyModel.getJobs();
	}

	@Override
	public String apply(User user, int jobID) {
		return applyModel.apply(user, jobID);
	}

	@Override
	public List<JobNotification> getAppliedJobs(User user) {
		return applyModel.getAppliedJobs(user);
	}

}
