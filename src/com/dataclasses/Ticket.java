package com.dataclasses;

import java.util.Date;

public class Ticket {

	private int ticketNumber;
	private Airport from;
	private Airport to;
	private String passsengerName;
	private Date onBoardingDate;
	private Flight flight;

	public Ticket(int ticketNumber, Airport from, Airport to, String passsengerName, Date onBoardingDate,
			Flight flight) {
		this.ticketNumber = ticketNumber;
		this.from = from;
		this.to = to;
		this.flight = flight;
		this.onBoardingDate = onBoardingDate;
		this.passsengerName = passsengerName;
	}
	
	public Flight getFlight() {
		return flight;
	}
	@Override
	public String toString() {		
		return "Ticket Number :\t" + ticketNumber + "\nSeat Number :\t" + flight.getFlightName() + " " + ticketNumber
				+ "\npassenger name :\t" + passsengerName + "\nfrom :\t"
				+ from.getLocation()
				+ "\nto :\t" + to.getLocation() + "\nOn Boarding Date :\t" + onBoardingDate + "\nFlight name :\t"
				+ flight.getFlightName();
	}

	public int getId() {
		return ticketNumber;
	}

}
