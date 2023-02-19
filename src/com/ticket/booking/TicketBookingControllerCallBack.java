package com.ticket.booking;

import java.util.Date;

import com.dataclasses.Flight;
import com.dataclasses.Ticket;

public interface TicketBookingControllerCallBack {

	Flight checkForFlight(String origin, String destination, Date date);

	public boolean isTatkal(Date onBoardingDate, Date currentDate);

	Ticket addPassenger(String name, String mobileNumber, String address, String aadhaar, String origin,
			String destination, Flight flight);



}
