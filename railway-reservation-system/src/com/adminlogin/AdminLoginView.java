package com.adminlogin;

import java.util.Scanner;

import com.dto.Admin;
import com.ticketbooking.TicketBookingView;
import com.ticketcancelling.TicketCancellingView;

public class AdminLoginView implements AdminLoginViewCallBack {

	private AdminLoginControllerCallBack adminLoginController;
	private Scanner scanner = new Scanner(System.in);

	public AdminLoginView() {
		adminLoginController = new AdminLoginController(this);
	}

	public static void main(String[] args) {
		AdminLoginView adminLoginView = new AdminLoginView();
		adminLoginView.start();
	}

	public void start() {
		System.out.println("\tIRCTC WELCOMES YOU\n ---------------------------------");
		System.out.println("Please enter 1 for ADMIN LOGIN");
		System.out.println("Please enter 2 for ticket booking");
		System.out.println("please enter 3 for ticket cancelling");
		System.out.println("Please enter 0 to exit");
		byte choice = scanner.nextByte();
		switch(choice) {

		case 1:
			checkForLogin();
			break;
		case 2:
			callTicketBooking();
			break;
		case 3:
			callTicketCancelling();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			start();
		}

	}

	private void checkForLogin() {

		System.out.println("Enter User Name");
		String userName = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();
		adminLoginController.checkCredentials(userName, password);
	}

	@Override
	public void loginSuccess(Admin admin) {
		System.out.println("\n-->Welcome " + admin.getUserName() + "<--\n");
	}

	private void callTicketBooking() {
		TicketBookingView ticketBookingView = new TicketBookingView();
		ticketBookingView.bookTicket();
	}

	private void callTicketCancelling() {
		TicketCancellingView ticketCancellingView = new TicketCancellingView();
		// ticketCancellingView.cancelTicket();
	}

	@Override
	public void loginFailed(String errorMessage) {
		System.out.println(errorMessage);
		checkForLogin();
	}

}
