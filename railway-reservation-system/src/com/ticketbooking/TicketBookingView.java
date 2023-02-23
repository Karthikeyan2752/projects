package com.ticketbooking;

import java.util.Date;
import java.util.Scanner;

import com.dto.Ticket;
import com.dto.User;
import com.userlogin.UserLoginView;

public class TicketBookingView implements TicketBookingViewCallBack {

	private Scanner scanner = new Scanner(System.in);
	private TicketBookingControllerCallBack ticketBookingController;

	public TicketBookingView() {
		this.ticketBookingController = new TicketBookingController(this);
	}

	public void bookTicket() {
		System.out.println("\twelcome to IRCTC booking portal");
		System.out.println("Already a user ? Please enter 1 for sign in.");
		System.out.println("New user ? Please enter 2 to create account.");
		System.out.println("Enter 0 to exit");
		User user = null;
		UserLoginView userLoginView = new UserLoginView();

		byte choice = scanner.nextByte();
		switch (choice) {
		case 1:
			user = userLogin(userLoginView);
			book(user);
			break;
		case 2:
			user = signUp(userLoginView);
			book(user);
		case 0:
			System.exit(0);
		default:
			bookTicket();
		}

	}

	private void getDetails(Date date, String depature, String arrival) {

		System.out.println("Enter your name : ");
		String name = scanner.next();
		System.out.println("Please enter your age : ");
		byte age = scanner.nextByte();
		System.out.println("Enter your preffered berth : (L/M/U)");
		String prefferedBerth = scanner.next();
		Ticket ticket = ticketBookingController.bookTicket(name, age, prefferedBerth, date, depature, arrival);
		System.out.println(ticket.toString());
	}

	private void book(User user) {
		System.out.println("/twelcome " + user.getName());
		System.out.println("Please Enter your depature location : ");
		String depature = scanner.next();
		System.out.println("Please Enter your arrival location : ");
		String arrival = scanner.next();
		Date date = getDateFromUser();
		System.out.println("Please enter the number of tickets : ");
		int numberOfTickets = scanner.nextInt();
		for (int i = numberOfTickets; i > 0; i--) {
			getDetails(date, depature, arrival);
		}
	}

	private Date getDateFromUser() {
		System.out.println("Please enter your depature date : (mm/dd/yyy)");
		String dateString = scanner.next();
		try {
			Date date = new Date(dateString);
			return date;
		} catch (Exception e) {
			System.out.println("Please enter correct date : ");
			getDateFromUser();
		}
		return null;
	}

	private User signUp(UserLoginView userLoginView) {

		return userLoginView.signUp();
	}

	private User userLogin(UserLoginView userLoginView) {

		return userLoginView.userLogin();
	}
	

}
