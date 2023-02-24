package com.ticketbooking;

import java.util.Date;
import java.util.Scanner;

import com.dto.Ticket;
import com.dto.User;
import com.payment.PaymentView;
import com.userlogin.UserLoginView;

public class TicketBookingView implements TicketBookingViewCallBack {

	private Scanner scanner = new Scanner(System.in);
	private TicketBookingControllerCallBack ticketBookingController;

	public TicketBookingView() {
		this.ticketBookingController = new TicketBookingController(this);
	}

	public void bookTicket() {
		System.out.println("\tWelcome to IRCTC booking portal\n");
		System.out.println("Already a user ?\nPlease enter 1 for sign in : \n");
		System.out.println("New user ?\nPlease enter 2 to create account : \n");
		System.out.println("Enter 0 to exit\n");
		User user = null;
		UserLoginView userLoginView = new UserLoginView();

		byte choice = scanner.nextByte();
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
		String name = scanner.next();
		System.out.println("Please enter your age : \n");
		byte age = scanner.nextByte();
		System.out.println("Enter your preffered berth : (L/M/U)\n");
		String prefferedBerth = scanner.next();
		Ticket ticket = ticketBookingController.bookTicket(name, age, prefferedBerth, date, depature, arrival);
		if (ticket != null) {
			System.out.println(ticket.toString());
		} else {
			System.out.println("Sorry ticket not available");
		}
	}

	private void book(User user) {
		System.out.println("\twelcome " + user.getName());
		System.out.println("Please Enter your depature location : \n");
		String depature = scanner.next();
		System.out.println("Please Enter your arrival location : \n");
		String arrival = scanner.next();
		Date date = getDateFromUser();
		boolean tatkal = ticketBookingController.isTatkal(date);
		if (tatkal) {
			System.out.println("Tatkal tickets only available !\n");
		}
		System.out.println("Please enter the number of tickets : \n");
		int numberOfTickets = scanner.nextInt();
		PaymentView paymentView = new PaymentView();
		int amount = paymentView.payment(depature, arrival, date, numberOfTickets, tatkal);
		if (amount == -1) {
			System.out.println("Tickets not available");
			return;
		}
		for (int i = numberOfTickets; i > 0; i--) {
			getDetails(date, depature, arrival);
		}
	}

	private Date getDateFromUser() {
		System.out.println("Please enter your depature date : (mm/dd/yyy)");
		String dateString = scanner.next();
		Date date = null;
		try {
			date = new Date(dateString);
			return date;
		} catch (Exception e) {
			System.out.println("Please enter correct date : ");
			return getDateFromUser();
		}
	}

	private User signUp(UserLoginView userLoginView) {

		return userLoginView.signUp();
	}

	private User userLogin(UserLoginView userLoginView) {

		return userLoginView.userLogin();
	}
	

}
