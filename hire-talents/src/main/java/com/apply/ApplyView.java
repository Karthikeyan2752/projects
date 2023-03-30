package com.apply;

import java.util.List;
import java.util.Scanner;

import com.model.JobNotification;
import com.model.User;
import com.util.UIValidator;

public class ApplyView {
	private Scanner scanner = new Scanner(System.in);
	private ApplyViewModel applyViewModel;

	public ApplyView() {
		this.applyViewModel = new ApplyViewModel(this);
	}

	public void displayControls(User user) {
		System.out.println("\t--------> candidate controls <---------\n");
		System.out.println("Enter 1 to view Available Jobs : ");
		System.out.println("Enter 2 to apply jobs : ");
		System.out.println("enter 3 to view applied jobs : ");
		System.out.println("Enter 4 to check for call letters : ");
		System.out.println("Enter 0 to exit\n");
		byte choice = UIValidator.getChoice();
		switch (choice) {
		case 1:
			viewJobs(user);
			break;
		case 2:
			viewAndApplyJobs(user);
			break;
		case 3:
			viewAppliedJobs(user);
			break;
		case 4:
			viewCallLetters(user);
			break;
		case 0:
			return;
		default:
			displayControls(user);
		}

	}

	private void viewCallLetters(User user) {
		List<JobNotification> jobs = applyViewModel.getCallLetters(user);

		for (JobNotification job : jobs) {
			System.out.println(job.getHR().toString());
			System.out.println(job.toString());
		}

		displayControls(user);

	}

	private void viewJobs(User user) {
		List<JobNotification> jobs = applyViewModel.getJobs();
		if (!jobs.isEmpty()) {
			for (JobNotification job : jobs) {
				System.out.println(job.toString());
			}
		} else {
			System.out.println("Currently no jobs are available !");
		}
		displayControls(user);
	}

	private void viewAndApplyJobs(User user) {
		List<JobNotification> jobs = applyViewModel.getJobs();
		if (!jobs.isEmpty()) {
			for (JobNotification job : jobs) {
				System.out.println(job.toString());
				apply(user);
			}
		} else {
			System.out.println("Currently no jobs are available !");
		}

	}

	private void apply(User user) {
		System.out.println("Enter the respective job ID to apply : ");
		System.out.println("Enter 0 skip and go to next job : \n");
		int jobID = UIValidator.getIntChoice();
		if (jobID != 0) {
			applyViewModel.apply(user, jobID);
			System.out.println("Applied successfully, waiting for HR response\n");
		}
		displayControls(user);
	}

	private void viewAppliedJobs(User user) {
		List<JobNotification> appliedJobs = applyViewModel.getAppliedJobs(user);
		for (JobNotification job : appliedJobs) {
			System.out.println(job.toString());
		}
		displayControls(user);
	}
}
