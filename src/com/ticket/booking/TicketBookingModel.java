package com.ticket.booking;

import java.util.Date;

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
		public Flight checkForFlight(String origin, String destination, Date date);

		public boolean isTatkal(Date onBoardingDate, Date currentDate);

		public Ticket addPassenger(String name, String mobileNumber, String address, String aadhaar, String origin,
				String destination, Flight flight);

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
	public Flight checkForFlight(String origin, String destination, Date date) {

		return DBRepository.getInstance().searchFlight(origin, destination, date);
	}

	@Override
	public boolean isTatkal(Date onBoardingDate, Date currentDate) {
		long millisPerDay = 1000 * 60 * 60;
		long timeDifference = Math.abs(onBoardingDate.getTime() - currentDate.getTime());
		long differenceInHour = timeDifference / millisPerDay;
		if (currentDate.before(onBoardingDate) && differenceInHour < 24) {
			return true;
		}
		return false;
	}

}
