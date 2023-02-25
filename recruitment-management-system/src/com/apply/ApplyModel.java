package com.apply;

import java.util.List;

import com.dto.JobNotification;
import com.dto.User;
import com.repository.DBRepository;

public class ApplyModel implements ApplyModelCallBack {

	private ApplyControllerCallBack applyController;

	public ApplyModel(ApplyController applyController) {
		this.applyController = applyController;
	}

	@Override
	public List<JobNotification> getJobs() {
		return DBRepository.getInstance().getJobs();
	}

	@Override
	public String apply(User user, int jobID) {
		return DBRepository.getInstance().apply(user, jobID);
	}

	@Override
	public List<JobNotification> getAppliedJobs(User user) {
		return DBRepository.getInstance().getAppliedJobs(user);
	}

}
