package com.dto;

import java.util.Date;

public class Ticket {

	private Passenger passenger;
	private Date travellingDate;
	private RailwayStation from;
	private RailwayStation to;
	private String seatNumber;

	public Ticket(Passenger passenger, RailwayStation from, RailwayStation to) {

		this.from = from;
		this.to = to;
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return passenger.toString();
	}

}
