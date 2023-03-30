package com.hrcontrols;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.model.HR;
import com.model.JobNotification;
import com.model.User;
import com.util.UIValidator;

public class HRControlView {

	private HRControlViewModel hRControlViewModel;
	private Scanner scanner = new Scanner(System.in);

	public HRControlView() {
		this.hRControlViewModel = new HRControlViewModel(this);
	}

	public void displayControls(HR hr) {
		System.out.println("\tWelcome! start recruiting for " + hr.getCompanyName() + "\n");
		System.out.println("Please enter 1 to post job notification ");
		System.out.println("Please enter 2 to see applied candidates ");
		System.out.println("Please enter 3 to schedule interview ");
		System.out.println("Please enter 4 to automate recruitment ");
		System.out.println("Please enter 5 to generate report ");
		System.out.println("Please enter 0 to exit\n");
		getChoiceAndProceed(hr);
	}

	private void getChoiceAndProceed(HR hr) {
		byte choice = scanner.nextByte();

		switch (choice) {
		case 1:
			postJob(hr);
			break;
		case 2:
			getAppliedCandidates();
			displayControls(hr);
			break;
		case 3:
			scheduleInterview(hr);
			break;
		case 4:
			automateRecruitment(hr);
			break;
		case 5:
			generateReport(hr);
			break;
		case 0:
			return;
		default:
			displayControls(hr);
		}

	}

	private void generateReport(HR hr) {

		List<JobNotification> jobs = hRControlViewModel.generateReport(hr);
		System.out.println("\tReport of " + hr.getCompanyName() + "\n");
		for (JobNotification job : jobs) {
			System.out.println(job.toString());
		}
		displayControls(hr);

	}

	private void automateRecruitment(HR hr) {

		JobNotification job = getJob(hr);
		hRControlViewModel.automateRecruitment(hr, job);
		displayControls(hr);
	}

	private void scheduleInterview(HR hr) {
		JobNotification job = getJob(hr);
		if (job == null) {
			System.out.println("Job not found! Try again");
			scheduleInterview(hr);
		}
		List<User> appliedCandidates = hRControlViewModel.getAppliedCandidates(job.getID());
		for (User appliedCandidate : appliedCandidates) {
			System.out.println(appliedCandidate.toString());
		}

		int stop = 0;
		List<User> selectedCandidates = new ArrayList<>();
		while (stop != -1) {
			System.out.println("Enter 0 to send call letter for all candidates : ");
			System.out.println("Enter respective candidate id to send call letter : ");
			System.out.println("Enter -1 to stop selecting and send call letter : \n");
			int choice = UIValidator.getIntChoiceForSelecting();
			for (User candidate : appliedCandidates) {
				if (choice == -1) {
					stop = -1;
				} else if (choice == 0) {
					selectedCandidates = appliedCandidates;
					stop = -1;
				} else {
					int id = candidate.getUserID();
					if (choice == id) {
						selectedCandidates.add(candidate);
					}
				}
			}

		}
		hRControlViewModel.sendCallLetter(hr, selectedCandidates, job);
		displayControls(hr);
	}

	private JobNotification getJob(HR hr) {
		System.out.println("Enter job ID : ");
		int jobID = UIValidator.getIntChoice();
		return hRControlViewModel.getJob(hr, jobID);
	}

	private List<User> getAppliedCandidates() {
		System.out.println("Enter job id : ");
		int jobID = UIValidator.getIntChoice();
		List<User> users = hRControlViewModel.getAppliedCandidates(jobID);
		if (users != null) {
			for (User user : users) {
				System.out.println(user.toString());
			}
		}
		return users;

	}

	private void postJob(HR hr) {
		System.out.println("Enter the job title : \n");
		String title = scanner.next();
		System.out.println("Enter the number of vacancies : \n");
		int numberOfVacancies = UIValidator.getIntChoice();
		System.out.println("Enter the required skills : (separated by commas)\n");
		String skills = scanner.next();
		System.out.println("Enter the interview date : \n");
		LocalDate endDate = UIValidator.getDateFromUser();
		int jobID = hRControlViewModel.postJob(hr, title, numberOfVacancies, endDate, skills);
		System.out.println("Job notification posted successfully!");
		System.out.println("Note job ID : " + jobID + "for further actions");
		displayControls(hr);

	}
}
