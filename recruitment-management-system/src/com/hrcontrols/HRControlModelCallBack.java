package com.hrcontrols;

import java.time.LocalDate;
import java.util.List;

import com.dto.HR;
import com.dto.JobNotification;
import com.dto.User;

public interface HRControlModelCallBack {

	int postJob(HR hr, String title, int numberOfVacancies, LocalDate endDate,
			String skills);

	List<User> getAppliedCandidates(int jobID);

	JobNotification getJob(HR hr, int jobID);

	String sendCallLetter(HR hr, List<User> selectedCandidates, JobNotification job);

	List<JobNotification> generateReport(HR hr);

	String automateRecruitment(HR hr, JobNotification job);

}
