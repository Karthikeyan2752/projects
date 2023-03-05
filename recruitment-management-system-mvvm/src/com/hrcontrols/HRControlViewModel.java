package com.hrcontrols;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.HR;
import com.model.JobNotification;
import com.model.User;
import com.repository.DB;

public class HRControlViewModel {

	private HRControlView hRControlView;

	public HRControlViewModel(HRControlView hRControlView) {
		this.hRControlView = hRControlView;
	}


	public int postJob(HR hr, String title, int numberOfVacancies, LocalDate endDate,
			String skills) {
		return DB.getInstance().postJob(hr, title, numberOfVacancies, endDate,
				skills);

	}


	public List<User> getAppliedCandidates(int jobID) {
		return DB.getInstance().getAppliedCandidates(jobID);
	}


	public JobNotification getJob(HR hr, int jobID) {
		return DB.getInstance().getJob(jobID);
	}


	public String sendCallLetter(HR hr, List<User> selectedCandidates, JobNotification job) {
		for (User candidate : selectedCandidates) {
			DB.getInstance().sendCallLetter(candidate.getUserID(), job.getID());
		}
		return "call Letter sent successfully";
	}


	public List<JobNotification> generateReport(HR hr) {
		return DB.getInstance().getJobs(hr.getId());
	}


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
