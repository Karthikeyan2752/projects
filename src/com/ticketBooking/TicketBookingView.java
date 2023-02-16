package com.ticketBooking;

import java.util.Scanner;

import com.dataclasses.Flight;
import com.dataclasses.Ticket;

public class TicketBookingView implements TicketBookingViewCallBack {
	private TicketBookingControllerCallBack ticketBookingController;
	private Scanner scanner = new Scanner(System.in);

	public TicketBookingView() {
		ticketBookingController = new TicketBookingController(this);
	}

	public void flightNotFound() {
		System.out.println("Sorry, flight not available for your destination!");
		System.out.println("Please enter 1 to continue booking");
		System.out.println("Enter 0 to exit");
		int choice = scanner.nextInt();
		if (choice == 1) {
			getUserDetails();
		} else {
			return;
		}
	}
	public void getUserDetails() {
		System.out.println("Please Enter your name: ");
		String name = scanner.next();
		System.out.println("Please Enter your 10 digit mobile number: ");
		String mobileNumber = scanner.next();
		System.out.println("Please Enter your residential address: ");
		String address = scanner.next();
		System.out.println("Please enter your AADHAAR number : ");
		String aadhaar = scanner.next();
		System.out.println("Please enter your origin location: ");
		String origin = scanner.next();
		System.out.println("Please enter your destination location: ");
		String destination = scanner.next();
		Flight flight = ticketBookingController.checkForFlight(origin, destination);
		if (flight == null) {
			flightNotFound();
			return;
		} else {
			Ticket ticket = ticketBookingController.addPassenger(name, mobileNumber, address, aadhaar, origin,
					destination, flight);
			System.out.println("Have a good journey!");
			System.out.println("Your ticket:\n" + ticket.toString());
			return;
		}

	}



}
