package com.adminlogin;

import java.util.Scanner;

import com.admincontrols.AdminControlView;
import com.getticket.GetTicketView;
import com.model.Admin;
import com.ticketbooking.TicketBookingView;
import com.ticketcancelling.TicketCancellingView;

public class AdminLoginView {

	private AdminLoginViewModel adminLoginViewModel;
	private Scanner scanner = new Scanner(System.in);

	public AdminLoginView() {
		adminLoginViewModel = new AdminLoginViewModel(this);
	}

	public static void main(String[] args) {
		AdminLoginView adminLoginView = new AdminLoginView();
		adminLoginView.start();
	}

	public void start() {
		System.out.println("\n\tIRCTC WELCOMES YOU\n ---------------------------------");
		System.out.println("Please enter 1 for ADMIN LOGIN");
		System.out.println("Please enter 2 for ticket booking");
		System.out.println("Please enter 3 for ticket cancelling");
		System.out.println("Please enter 4 to view your ticket status");
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
		case 4:
			callGetTicket();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			start();
		}

	}

	private void callGetTicket() {
		GetTicketView getTicketView = new GetTicketView();
		getTicketView.start();

	}

	private void checkForLogin() {

		System.out.println("Enter User Name");
		String userName = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();
		adminLoginViewModel.checkCredentials(userName, password);
	}

	public void loginSuccess(Admin admin) {
		System.out.println("\n-->Welcome Admin<--\n");
		AdminControlView adminControlView = new AdminControlView();
		adminControlView.displayControls();
		start();
	}

	private void callTicketBooking() {
		TicketBookingView ticketBookingView = new TicketBookingView();
		ticketBookingView.bookTicket();
		start();
	}

	private void callTicketCancelling() {
		TicketCancellingView ticketCancellingView = new TicketCancellingView();
		ticketCancellingView.cancelTicket();
		start();
	}

	public void loginFailed(String errorMessage) {
		System.out.println(errorMessage);
		checkForLogin();
	}

}
