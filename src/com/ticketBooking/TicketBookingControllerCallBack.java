package com.ticketBooking;

import com.dataclasses.Flight;
import com.dataclasses.Ticket;

public interface TicketBookingControllerCallBack {

	Flight checkForFlight(String origin, String destination);

	Ticket addPassenger(String name, String mobileNumber, String address, String aadhaar, String origin,
			String destination, Flight flight);

	boolean payment(int amount, Flight flight);

}
