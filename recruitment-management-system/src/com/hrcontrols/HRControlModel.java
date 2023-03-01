package com.hrcontrols;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dto.HR;
import com.dto.JobNotification;
import com.dto.User;
import com.repository.DB;

public class HRControlModel implements HRControlModelCallBack {

	private HRControlControllerCallBack hRControlModel;

	public HRControlModel(HRControlController hrControlController) {
		this.hRControlModel = hRControlModel;
	}

	@Override
	public int postJob(HR hr, String title, int numberOfVacancies, LocalDate endDate,
			String skills) {
		return DB.getInstance().postJob(hr, title, numberOfVacancies, endDate,
				skills);

	}

	@Override
	public List<User> getAppliedCandidates(int jobID) {
		return DB.getInstance().getAppliedCandidates(jobID);
	}

	@Override
	public JobNotification getJob(HR hr, int jobID) {
		return DB.getInstance().getJob(jobID);
	}

	@Override
	public String sendCallLetter(HR hr, List<User> selectedCandidates, JobNotification job) {
		for (User candidate : selectedCandidates) {
			DB.getInstance().sendCallLetter(candidate.getUserID(), job.getID());
		}
		return "call Letter sent successfully";
	}

	@Override
	public List<JobNotification> generateReport(HR hr) {
		return DB.getInstance().getJobs(hr.getId());
	}

	@Override
	public String automateRecruitment(HR hr, JobNotification job) {
		List<User> candidates = DB.getInstance().getAppliedCandidates(job.getID());
		List<User> selectedCandidates = new ArrayList<>();
		String[] skills = job.getSkills().split(",");

		for(User candidate:candidates) {
			String[] candidateSkills = candidate.getSkills().split(",");
			for(String requiredSkill:skills) {
				for (String skill : candidateSkills) {
					if (requiredSkill.equals(skill)) {
						selectedCandidates.add(candidate);
						break;
					}
				}
			}
		}
		if (selectedCandidates.size() == 0) {
			return "candidates does not match!";
		}

		for (User candidate : selectedCandidates) {
			DB.getInstance().sendCallLetter(candidate.getUserID(), job.getID());
		}

		return "Call letter sended for skill matching candidates";
	}

}
