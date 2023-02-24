package com.hrcontrols;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dto.HR;
import com.dto.JobNotification;
import com.dto.User;
import com.repository.DBRepository;

public class HRControlModel implements HRControlModelCallBack {

	private HRControlControllerCallBack hRControlModel;

	public HRControlModel(HRControlController hrControlController) {
		this.hRControlModel = hRControlModel;
	}

	@Override
	public int postJob(HR hr,String title, int numberOfVacancies, Date endDate, int minExperience, int maxExperience,
			List<String> skills) {
		return DBRepository.getInstance().postJob(hr, title, minExperience, maxExperience, numberOfVacancies, endDate,
				skills);

	}

	@Override
	public List<User> getAppliedCandidates(int jobID) {
		return DBRepository.getInstance().getAppliedCandidates(jobID);
	}

	@Override
	public JobNotification getJob(HR hr, int jobID) {
		return DBRepository.getInstance().getJob(hr, jobID);
	}

	@Override
	public String sendCallLetter(HR hr, List<User> selectedCandidates, JobNotification job, Date interviewDate) {
		return DBRepository.getInstance().sendCallLetter(hr, selectedCandidates, job, interviewDate);
	}

	@Override
	public List<JobNotification> generateReport(HR hr) {
		return DBRepository.getInstance().generateReport(hr);
	}

	@Override
	public String automateRecruitment(HR hr, JobNotification job) {
		List<User> selectedCandidates = new ArrayList<>();
		for (User candidate : job.getAppliedCandidates()) {
			aa: for (String requiredSkill : job.getSkills()) {
				for (String skill : candidate.getSkills()) {
					if (requiredSkill.equals(skill)) {
						selectedCandidates.add(candidate);
						continue aa;
					}
				}
			}
		}
		if (selectedCandidates.size() == 0) {
			return "candidates does not match!";
		}
		DBRepository.getInstance().sendCallLetter(hr, selectedCandidates, job, new Date());
		return "Call letter sended for skill matching candidates";
	}

}
