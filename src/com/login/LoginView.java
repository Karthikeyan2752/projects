package com.login;

import java.util.Scanner;

import com.dataclasses.Admin;
import com.ticketBooking.TicketBookingView;

public class LoginView implements LoginViewCallBack {

	private LoginControllerCallBack loginController;
	private static Scanner scanner = new Scanner(System.in);

	public LoginView() {
		loginController = new LoginController(this);
	}
	
	static public void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.start(loginView);
	}

	public void start(LoginView loginView) {
		System.out.println("\t>>>> WELCOME TO BERMUDA AIRWAYS >>>>");
		System.out.println("press 1 for admin controls");
		System.out.println("press 2 for ticket booking");
		System.out.println("press 0 to exit");
		int choice = scanner.nextInt();
		if (choice == 1) {
			loginView.checkForLogin();
		} else if (choice == 2) {
			TicketBookingView ticketBookingView = new TicketBookingView();
			ticketBookingView.getUserDetails();
			System.out.println("Enter 1 for admin controls");
			System.out.println("Enter 2 for ticket booking");
			System.out.println("Enter 3 for cancel ticket");
			System.out.println("Enter 0 exit");
			int choice2 = scanner.nextInt();
			if (choice2 == 1) {
				loginView.checkForLogin();
			} else if (choice2 == 2) {
				ticketBookingView.getUserDetails();
			} else if (choice2 == 3) {
				ticketBookingView.cancelTicket();
				loginView.start(loginView);
			} else {
				return;
			}
		}
	}
	

	private void checkForLogin() {
		System.out.println("Enter User Name");
		String userName = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();
		loginController.checkCredentials(userName, password);	
	}

	@Override
	public void loginSuccess(Admin admin) {
		System.out.println(">--  Welcome " + admin.getUserName() + "  --<");
		adminControls();
	}

	private void printChoices() {

		System.out.println("Please Enter 1 to see the available flights");
		System.out.println("Please Enter 2 to see the available airports");
		System.out.println("Please Enter 3 to see the number of tickets booked");
		System.out.println("Please Enter 4 to available flights in airport");
		System.out.println("Please Enter 5 to see the passenger details");
		System.out.println("Please Enter 0 to exit");
	}

	private void adminControls() {
		printChoices();
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			loginController.displayFlights();
			adminControls();
			break;
		case 2:
			loginController.displayAirports();
			adminControls();
			break;
		case 3:
			loginController.displayTicketsCount();
			adminControls();
			break;
		case 4:
			loginController.displayFlightsInAirport();
			adminControls();
			break;
		case 5:
			loginController.displayPassengerDetails();
			adminControls();
			break;
		default:
			System.out.println("Exitting.... Thank You!");
			break;
		}

	}

	@Override
	public void loginFailed(String errorMessage) {
		System.out.println(errorMessage);
		checkForLogin();
	}
}
