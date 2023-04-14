package com.hrcontrols;

import java.util.ArrayList;
import java.util.List;

import com.model.JobNotification;
import com.model.User;
import com.repository.DB;

public class HRControlViewModel {


	public int postJob(int HRID, String title, int numberOfVacancies, String skills, String description,
			String requirements, String responsibilities, int experience, String type, String location) {
		return DB.getInstance().postJob(HRID, title, numberOfVacancies, skills, description, requirements,
				responsibilities, experience, type, location);

	}

	public String updateHR(int userID, String name, String mobileNumber, String website, String companyName,
			String location, String about) {
		return DB.getInstance().updateHR(userID, name, mobileNumber, website, companyName, location, about);
	}

	public List<User> getAppliedCandidates(int jobID) {
		return DB.getInstance().getAppliedCandidates(jobID);
	}

	public JobNotification getJob(int jobID) {
		return DB.getInstance().getJob(jobID);
	}


	public String sendCallLetter(int userID, int jobID, String venue, String date, String time) {
		return DB.getInstance().sendCallLetter(userID, jobID, venue, date, time);
	}

	public int getTotalNoOfJobsPosted(int userID) {
		return DB.getInstance().getPostedJobsCount(userID);
	}

	public int getTotalNoOfSelectedCandidates(int userID) {
		return DB.getInstance().getSelectedCandidatesCount(userID);
	}

	public int getNoOfSelectedCandidates(int jobID) {
		return DB.getInstance().getNoOfSelectedCandidates(jobID);
	}

	public int getNoOfAppliedCandidates(int jobID) {
		return DB.getInstance().getNoOfAppliedCandidates(jobID);
	}

	public String getCompanyName(int userID) {
		return DB.getInstance().getHR(userID).getCompanyName();
	}

	public List<User> automateHiring(int jobID, String venue, String date, String time) {
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
			DB.getInstance().sendCallLetter(candidate.getUserID(), job.getID(), venue, date, time);
		}

		return selectedCandidates;
	}

	public List<JobNotification> getJobsPostedByHR(int userID) {
		return DB.getInstance().getJobsPostedByHR(userID);
	}

	public String deactivateJob(int jobID) {
		return DB.getInstance().deactivateJob(jobID);
	}

}
