package com.ticketbooking;

import java.util.Date;
import java.util.Scanner;

import com.model.Ticket;
import com.model.User;
import com.payment.PaymentView;
import com.userlogin.UserLoginView;
import com.util.UIValidator;

public class TicketBookingView {

	private Scanner scanner = new Scanner(System.in);
	private TicketBookingViewModel ticketBookingViewModel;

	public TicketBookingView() {
		this.ticketBookingViewModel = new TicketBookingViewModel(this);
	}

	public void bookTicket() {
		System.out.println("\tWelcome to IRCTC booking portal\n");
		System.out.println("Already a user ?\nPlease enter 1 for sign in : \n");
		System.out.println("New user ?\nPlease enter 2 to create account : \n");
		System.out.println("Enter 0 to exit\n");
		User user = null;
		UserLoginView userLoginView = new UserLoginView();

		byte choice = UIValidator.getChoice();
		switch (choice) {
		case 1:
			user = userLogin(userLoginView);
			if (user == null) {
				System.out.println("User not found !\n");
				bookTicket();
			}
			book(user);
			break;
		case 2:
			user = signUp(userLoginView);
			book(user);
		case 0:
			System.out.println("\tTHANK YOU \nExitting...");
			System.exit(0);
		default:
			bookTicket();
		}

	}

	private void getDetails(Date date, String depature, String arrival) {

		System.out.println("Enter your name : \n");
		String name = UIValidator.getName();
		System.out.println("Please enter your age : \n");
		byte age = UIValidator.getChoice();
		System.out.println("Enter your preffered berth : (L/M/U)\n");
		String prefferedBerth = scanner.next();
		Ticket ticket = ticketBookingViewModel.bookTicket(name, age, prefferedBerth, date, depature, arrival);
		if (ticket != null) {
			System.out.println("\tIRCTC\n");
			System.out.println(ticket.toString());
		} else {
			System.out.println("Sorry ticket not available");
		}
	}

	private void book(User user) {
		System.out.println("\twelcome " + user.getName());
		System.out.println("Please Enter your depature location : \n");
		String depature = UIValidator.getName();
		System.out.println("Please Enter your arrival location : \n");
		String arrival = UIValidator.getName();
		Date date = UIValidator.getDateFromUser();
		boolean tatkal = ticketBookingViewModel.isTatkal(date);
		if (tatkal) {
			System.out.println("Tatkal tickets only available !\n");
		}
		System.out.println("Please enter the number of tickets : \n");
		int numberOfTickets = UIValidator.getIntChoice();
		PaymentView paymentView = new PaymentView();
		int amount = paymentView.payment(depature, arrival, date, numberOfTickets, tatkal);
		if (amount == -1) {
			System.out.println("Something went wrong");
			return;
		}
		for (int i = numberOfTickets; i > 0; i--) {
			getDetails(date, depature, arrival);
		}
	}


	private User signUp(UserLoginView userLoginView) {

		return userLoginView.signUp();
	}

	private User userLogin(UserLoginView userLoginView) {

		return userLoginView.userLogin();
	}
	

}
