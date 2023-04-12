package com.hrcontrols;

import java.util.ArrayList;
import java.util.List;

import com.model.HR;
import com.model.JobNotification;
import com.model.User;
import com.repository.DB;

public class HRControlViewModel {


	public int postJob(int HRID, String title, int numberOfVacancies, String skills, String description,
			String requirements, String responsibilities, int experience, String type, String location) {
		return DB.getInstance().postJob(HRID, title, numberOfVacancies, skills, description, requirements,
				responsibilities, experience, type, location);

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

	public int getNoOfSelectedCandidates(int jobID) {
		return DB.getInstance().getNoOfSelectedCandidates(jobID);
	}

	public int getNoOfAppliedCandidates(int jobID) {
		return DB.getInstance().getNoOfAppliedCandidates(jobID);
	}

	public List<User> automateRecruitment(int jobID) {
		List<User> candidates = DB.getInstance().getAppliedCandidates(jobID);
		JobNotification job = DB.getInstance().getJob(jobID);
		List<User> selectedCandidates = new ArrayList<>();
		String[] skills = job.getSkills().split(",");
		aa:
		for(User candidate:candidates) {
			String[] candidateSkills = candidate.getSkills().split(",");
			for(String requiredSkill:skills) {
				for (String skill : candidateSkills) {
					if (requiredSkill.equals(skill)) {
						selectedCandidates.add(candidate);
						continue aa;
					}
				}
			}
		}

		for (User candidate : selectedCandidates) {
			DB.getInstance().sendCallLetter(candidate.getUserID(), job.getID());
		}

		return selectedCandidates;
	}

}
