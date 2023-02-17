package com.ticketBooking;

import com.dataclasses.Admin;
import com.dataclasses.Airport;
import com.dataclasses.Flight;
import com.dataclasses.Passenger;
import com.dataclasses.Ticket;
import com.repository.DBRepository;

public class TicketBookingModel implements TicketBookingModelCallBack {
	static int ticketNumber = 0;
	private TicketBookingModelControllerCallBack ticketBookingController;

	public TicketBookingModel(TicketBookingModelControllerCallBack ticketBookingController) {
		this.ticketBookingController = ticketBookingController;
	}

	public interface TicketBookingModelControllerCallBack {

		void loginSuccess(Admin adminUser);
		void loginFailiure(String string);

	}

	@Override
	public Ticket addPassenger(String name, String mobileNumber, String address, String aadhaar, String origin,
			String destination, Flight flight) {
		Ticket ticket = new Ticket(ticketNumber++, new Airport(origin), new Airport(destination), name,
				flight.getOnBoardingDate(), flight);
		Passenger passenger = new Passenger(name, mobileNumber, address, aadhaar, ticket);
		DBRepository.getInstance().addPassenger(passenger, flight, ticket);
		return ticket;
	}

	@Override
	public boolean payment(int amount, Flight flight) {
		return DBRepository.getInstance().makePayment(amount, flight);
	}

	@Override
	public Flight checkForFlight(String origin, String destination) {
		return DBRepository.getInstance().searchFlight(origin, destination);
	}

	@Override
	public boolean cancelTicket(int ticketId) {
		return DBRepository.getInstance().cancelTicket(ticketId);

	}
}
