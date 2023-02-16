package com.ticketBooking;

import java.util.Date;
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
		} else if (choice == 0) {
			System.exit(0);
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
			if (!passengerConsent(flight)) {
				return;
			}
			int amount = payment(flight);
			boolean paid = ticketBookingController.payment(amount, flight);
			if (paid) {
				Ticket ticket = ticketBookingController.addPassenger(name, mobileNumber, address, aadhaar, origin,
						destination, flight);
				System.out.println("Have a good journey!");
				System.out.println("Your ticket:\n" + ticket.toString());
			} else {
				System.out.println("Payment failed!, Try again");
				ticketBookingController.payment(amount, flight);
			}
			return;
		}

	}

	public boolean passengerConsent(Flight flight) {
		Date onBoardingDate = flight.getOnBoardingDate();
		System.out.println("ON BOARDING DATE: " + onBoardingDate);
		System.out.println("Are you Okay with the ON BOARDING DATE");
		System.out.println("Enter 1 to continue");
		System.out.println("Enter 2 to booking page");
		System.out.println("Enter 0 to exit");
		int choice = scanner.nextInt();
		if (choice == 1) {
			return true;
		} else if (choice == 2) {
			getUserDetails();
		} else if (choice == 0) {
			System.exit(0);
		}
		return false;
	}

	public int payment(Flight flight) {
		System.out.println("Total amount to be paid: " + flight.getTicketPrice());
		System.out.println("Enter the amount mentioned above to make payment");
		int amount = scanner.nextInt();
		return amount;
	}



}
