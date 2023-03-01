package com.hrcontrols;

import java.util.Date;
import java.util.List;

import com.dto.HR;
import com.dto.JobNotification;
import com.dto.User;

public class HRControlController implements HRControlControllerCallBack {

	private HRControlModelCallBack hRControlModel;
	private HRControlViewCallBack hRControlView;

	public HRControlController(HRControlView hRControlView) {
		this.hRControlModel = new HRControlModel(this);
		this.hRControlView = hRControlView;
	}

	@Override
	public int postJob(HR hr, String title, int numberOfVacancies, Date endDate, int minExperience, int maxExperience,
			List<String> skills) {
		return hRControlModel.postJob(hr, title, numberOfVacancies, endDate, minExperience, maxExperience, skills);

	}

	@Override
	public List<User> getAppliedCandidates(int jobID) {
		return hRControlModel.getAppliedCandidates(jobID);
	}

	@Override
	public JobNotification getJob(HR hr, int jobID) {
		return hRControlModel.getJob(hr, jobID);
	}

	@Override
	public String sendCallLetter(HR hr, List<User> selectedCandidates, JobNotification job, Date interviewDate) {
		return hRControlModel.sendCallLetter(hr, selectedCandidates, job, interviewDate);
	}

	@Override
	public List<JobNotification> generateReport(HR hr) {
		return hRControlModel.generateReport(hr);
	}

	@Override
	public String automateRecruitment(HR hr, JobNotification job) {
		return hRControlModel.automateRecruitment(hr, job);
	}

}
