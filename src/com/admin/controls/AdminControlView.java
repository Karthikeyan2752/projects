package com.admin.controls;

import java.util.Scanner;

import com.login.LoginView;

public class AdminControlView implements AdminControlViewCallBack {
	private AdminControlController adminControlController;
	private Scanner scanner = new Scanner(System.in);

	public AdminControlView() {
		adminControlController = new AdminControlController(this);
	}


	@Override
	public void printChoices() {

		System.out.println("Please Enter 1 to see the available flights");
		System.out.println("Please Enter 2 to see the available airports");
		System.out.println("Please Enter 3 to see the number of tickets booked");
		System.out.println("Please Enter 4 to available flights in airport");
		System.out.println("Please Enter 5 to see the passenger details");
		System.out.println("Please Enter 0 to exit");
	}



	@Override
	public void adminControls(LoginView loginView) {
		printChoices();
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			adminControlController.displayFlights();
			loginView.start(loginView);
			break;
		case 2:
			adminControlController.displayAirports();
			loginView.start(loginView);
			break;
		case 3:
			adminControlController.displayTicketsCount();
			loginView.start(loginView);
			break;
		case 4:
			adminControlController.displayFlightsInAirports();
			loginView.start(loginView);
			break;
		case 5:
			adminControlController.displayPassengerDetails();
			loginView.start(loginView);
			break;
		default:
			System.out.println("Exitting.... Thank You!");
			break;
		}

	}


}
