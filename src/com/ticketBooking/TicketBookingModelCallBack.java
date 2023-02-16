package com.ticketBooking;

import com.dataclasses.Flight;
import com.dataclasses.Ticket;

public interface TicketBookingModelCallBack {

	public Flight checkForFlight(String origin, String destination);

	public Ticket addPassenger(String name, String mobileNumber, String address, String aadhaar, String origin,
			String destination, Flight flight);

}
