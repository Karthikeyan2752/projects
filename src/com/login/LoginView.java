package com.login;

import java.util.Scanner;

import com.admin.controls.AdminControlView;
import com.dataclasses.Admin;
import com.ticket.booking.TicketBookingView;
import com.ticket.cancelling.TicketCancellingView;

public class LoginView implements LoginViewCallBack {

	private LoginControllerCallBack loginController;
	private static Scanner scanner = new Scanner(System.in);

	public LoginView() {
		loginController = new LoginController(this);
	}
	
	public static void main(String[] args) {
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
			ticketBookingView.getNumberOfTickets();
			System.out.println("Enter 1 for admin controls");
			System.out.println("Enter 2 for ticket booking");
			System.out.println("Enter 3 for cancel ticket");
			System.out.println("Enter 0 exit");
			int choice2 = scanner.nextInt();
			if (choice2 == 1) {
				loginView.checkForLogin();
			} else if (choice2 == 2) {
				ticketBookingView.getNumberOfTickets();
			} else if (choice2 == 3) {
				TicketCancellingView ticketCancellingView = new TicketCancellingView();
				ticketCancellingView.getTicketId();
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
		AdminControlView adminControlView = new AdminControlView();
		adminControlView.adminControls(this);
	}



	@Override
	public void loginFailed(String errorMessage) {
		System.out.println(errorMessage);
		checkForLogin();
	}
}
