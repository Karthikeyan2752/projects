package com.ticket.booking;

import java.util.Date;

import com.dataclasses.Flight;
import com.dataclasses.Ticket;

public interface TicketBookingModelCallBack {

	public Flight checkForFlight(String origin, String destination, Date date);

	public Ticket addPassenger(String name, String mobileNumber, String address, String aadhaar, String origin,
			String destination, Flight flight);

	public boolean isTatkal(Date onBoardingDate, Date currentDate);


}
