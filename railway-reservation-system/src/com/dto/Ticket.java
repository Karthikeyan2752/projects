package com.dto;

import java.util.Date;

public class Ticket {

	private Passenger passenger;
	private Train train;
	private Date travellingDate;
	private RailwayStation from;
	private RailwayStation to;
	private String seatNumber;

	public Ticket(Train train, Passenger passenger, RailwayStation from, RailwayStation to) {

		this.from = from;
		this.to = to;
		this.passenger = passenger;
	}

	public Train getTrain() {
		return train;
	}
	@Override
	public String toString() {
		return passenger.toString();
	}

	public Passenger getPassenger() {
		return passenger;
	}

}
