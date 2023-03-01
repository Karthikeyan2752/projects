package com.apply;

import java.util.List;
import java.util.Scanner;

import com.dto.CallLetter;
import com.dto.JobNotification;
import com.dto.User;
import com.util.UIValidator;

public class ApplyView implements ApplyViewCallBack {
	private Scanner scanner = new Scanner(System.in);
	private ApplyControllerCallBack applyController;

	public ApplyView() {
		this.applyController = new ApplyController(this);
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
		if (user.getCallLetter().isEmpty()) {
			System.out.println("No call letters received !");
		} else {
			for (CallLetter callLetter : user.getCallLetter()) {
				System.out.println(callLetter.toString());
			}
		}
		displayControls(user);

	}

	private void viewJobs(User user) {
		List<JobNotification> jobs = applyController.getJobs();
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
		List<JobNotification> jobs = applyController.getJobs();
		if (!jobs.isEmpty()) {
			for (JobNotification job : jobs) {
				System.out.println(job.toString());
			}
		} else {
			System.out.println("Currently no jobs are available !");
		}
		apply(user);
	}

	private void apply(User user) {
		System.out.println("Enter the respective job ID to apply : ");
		int jobID = UIValidator.getIntChoice();
		applyController.apply(user, jobID);
		System.out.println("Applied successfully, waiting for HR response\n");
		displayControls(user);
	}

	private void viewAppliedJobs(User user) {
		List<JobNotification> appliedJobs = applyController.getAppliedJobs(user);
		for (JobNotification job : appliedJobs) {
			System.out.println(job.toString());
		}
		displayControls(user);
	}
}
