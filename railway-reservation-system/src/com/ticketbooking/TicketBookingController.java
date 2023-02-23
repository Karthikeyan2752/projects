package com.ticketbooking;

import java.util.Date;

import com.dto.Ticket;
import com.ticketbooking.TicketBookingModel.TicketBookingModelControllerCallBack;

public class TicketBookingController implements TicketBookingControllerCallBack, TicketBookingModelControllerCallBack {

	private TicketBookingViewCallBack ticketBookingView;
	private TicketBookingModelCallBack ticketBookingModel;

	public TicketBookingController(TicketBookingView ticketBookingView) {
		this.ticketBookingView = ticketBookingView;
		this.ticketBookingModel = new TicketBookingModel(this);
	}

	@Override
	public Ticket bookTicket(String name, byte age, String prefferedBerth, Date date, String depature, String arrival) {
		return ticketBookingModel.bookTicket(name, age, prefferedBerth, date, depature, arrival);

	}

	@Override
	public boolean isTatkal(Date date) {
		return ticketBookingModel.isTatkal(date);
	}

}
