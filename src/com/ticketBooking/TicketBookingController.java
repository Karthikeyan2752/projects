package com.ticketBooking;

import com.dataclasses.Admin;
import com.dataclasses.Flight;
import com.dataclasses.Ticket;
import com.ticketBooking.TicketBookingModel.TicketBookingModelControllerCallBack;

public class TicketBookingController implements TicketBookingControllerCallBack, TicketBookingModelControllerCallBack {
	private TicketBookingViewCallBack ticketBookingView;
	private TicketBookingModelCallBack ticketBookingModel;

	public TicketBookingController(TicketBookingView ticketBookingView) {
		this.ticketBookingView = ticketBookingView;
		this.ticketBookingModel = new TicketBookingModel(this);
	}

	@Override
	public Flight checkForFlight(String origin, String destination) {
		return ticketBookingModel.checkForFlight(origin, destination);
	}

	@Override
	public Ticket addPassenger(String name, String mobileNumber, String address, String aadhaar, String origin,
			String destination, Flight flight) {
		return ticketBookingModel.addPassenger(name, mobileNumber, address, aadhaar, origin, destination, flight);
	}
	@Override
	public void loginSuccess(Admin adminUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loginFailiure(String string) {
		// TODO Auto-generated method stub

	}

}
