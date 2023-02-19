package com.ticket.booking;

import java.util.Date;

import com.dataclasses.Flight;
import com.dataclasses.Ticket;
import com.ticket.booking.TicketBookingModel.TicketBookingModelControllerCallBack;

public class TicketBookingController implements TicketBookingControllerCallBack, TicketBookingModelControllerCallBack {
	private TicketBookingViewCallBack ticketBookingView;
	private TicketBookingModelCallBack ticketBookingModel;

	public TicketBookingController(TicketBookingView ticketBookingView) {
		this.ticketBookingView = ticketBookingView;
		this.ticketBookingModel = new TicketBookingModel(this);
	}

	@Override
	public Flight checkForFlight(String origin, String destination, Date date) {
		return ticketBookingModel.checkForFlight(origin, destination, date);
	}

	@Override
	public Ticket addPassenger(String name, String mobileNumber, String address, String aadhaar, String origin,
			String destination, Flight flight) {
		return ticketBookingModel.addPassenger(name, mobileNumber, address, aadhaar, origin, destination, flight);
	}

	@Override
	public boolean isTatkal(Date onBoardingDate, Date currentDate) {
		return ticketBookingModel.isTatkal(onBoardingDate, currentDate);
	}


}
