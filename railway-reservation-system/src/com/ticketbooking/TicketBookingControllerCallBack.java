package com.ticketbooking;

import java.util.Date;

import com.dto.Ticket;

public interface TicketBookingControllerCallBack {

	Ticket bookTicket(String name, byte age, String prefferedBerth, Date date, String depature, String arrival);

	boolean isTatkal(Date date);

}
