package com.hrcontrols;

import java.util.Date;
import java.util.List;

import com.dto.HR;
import com.dto.JobNotification;
import com.dto.User;

public interface HRControlModelCallBack {

	int postJob(HR hr, String title, int numberOfVacancies, Date endDate, int minExperience, int maxExperience,
			List<String> skills);

	List<User> getAppliedCandidates(int jobID);

	JobNotification getJob(HR hr, int jobID);

	String sendCallLetter(HR hr, List<User> selectedCandidates, JobNotification job, Date interviewDate);

	List<JobNotification> generateReport(HR hr);

	String automateRecruitment(HR hr, JobNotification job);

}
