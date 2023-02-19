package com.ticket.booking;

import java.util.Date;
import java.util.Scanner;

import com.dataclasses.Flight;
import com.dataclasses.Ticket;
import com.payment.PaymentView;

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
			getNumberOfTickets();
		} else if (choice == 0) {
			System.exit(0);
		} else {
			return;
		}
	}

	public void getNumberOfTickets() {
		System.out.println("Enter the number of tickets: ");
		int count = scanner.nextInt();
		for (int i = 0; i < count; i++) {
			getUserDetails(count);
			count = -1;
		}
	}

	public void getUserDetails(int count) {

		System.out.println("Please Enter your name: ");
		String name = scanner.next();
		System.out.println("Please Enter your 10 digit mobile number: ");
		String mobileNumber = scanner.next();
		System.out.println("Please Enter your residential address: ");
		String address = scanner.next();
		System.out.println("Please enter your PASSPORT number : ");
		String aadhaar = scanner.next();
		System.out.println("Please enter your origin location: ");
		String origin = scanner.next();
		System.out.println("Please enter your destination location: ");
		String destination = scanner.next();
		System.out.println("Please enter your on boarding date: (mm/dd/yyy)");
		String dateString = scanner.next();
		Date date = new Date(dateString);

		Flight flight = ticketBookingController.checkForFlight(origin, destination, date);
		if (flight == null) {
			flightNotFound();
			return;
		} else {
			if (!passengerConsent(flight)) {
				return;
			}
			PaymentView paymentView = new PaymentView();
			boolean paid = true;
			boolean call = false;
			if (!call) {
				paid = paymentView.payment(flight, count);
				call = true;
			}
			if (paid) {
				Ticket ticket = ticketBookingController.addPassenger(name, mobileNumber, address, aadhaar, origin,
						destination, flight);
				System.out.println("Have a good journey!");
				System.out.println("-----------------------------------------------");
				System.out.println("\tYour ticket:\n" + ticket.toString());
				System.out.println("-----------------------------------------------");
				while (count > 1) {
					getCopassengerDetails(origin, destination, flight);
					count--;
				}

			} else {
				System.out.println("Payment failed!, Try again");
				paymentView.payment(flight, count);
			}
			return;
		}

	}

	private void getCopassengerDetails(String origin, String destination, Flight flight) {
		System.out.println("Please Enter your name: ");
		String name = scanner.nextLine();
		System.out.println("Please Enter your 10 digit mobile number: ");
		String mobileNumber = scanner.nextLine();
		System.out.println("Please Enter your residential address: ");
		String address = scanner.nextLine();
		System.out.println("Please enter your PASSPORT number : ");
		String aadhaar = scanner.nextLine();
		Ticket ticket = ticketBookingController.addPassenger(name, mobileNumber, address, aadhaar, origin, destination,
				flight);
		System.out.println("Have a good journey!");
		System.out.println("-----------------------------------------------");
		System.out.println("Your ticket:\n" + ticket.toString());
		System.out.println("-----------------------------------------------");
	}

	public boolean passengerConsent(Flight flight) {
		Date onBoardingDate = flight.getOnBoardingDate();
		Date currentDate = new Date();
		boolean tatkal = isTatkal(onBoardingDate, currentDate);
		if (tatkal) {
			System.out.println("Tatkal ticket Only Available!");
		}
		return onBoradingDateConsent(onBoardingDate);

	}

	private boolean onBoradingDateConsent(Date onBoardingDate) {
		System.out.println("ON BOARDING DATE: " + onBoardingDate);
		System.out.println("Are you Okay with the ON BOARDING DATE");
		System.out.println("Enter 1 to continue");
		System.out.println("Enter 2 to booking page");
		System.out.println("Enter 0 to exit");
		int choice = scanner.nextInt();
		if (choice == 1) {
			return true;
		} else if (choice == 2) {
			getNumberOfTickets();
		} else if (choice == 0) {
			System.exit(0);
		}
		return false;
	}

	public boolean isTatkal(Date onBoardingDate, Date currentDate) {

		return ticketBookingController.isTatkal(onBoardingDate, currentDate);
	}



}
