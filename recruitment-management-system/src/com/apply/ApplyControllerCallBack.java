package com.apply;

import java.util.List;

import com.dto.JobNotification;
import com.dto.User;

public interface ApplyControllerCallBack {

	List<JobNotification> getJobs();

	String apply(User user, int jobID);

	List<JobNotification> getAppliedJobs(User user);

}
