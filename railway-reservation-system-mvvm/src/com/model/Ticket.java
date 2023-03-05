package com.model;

import java.util.Date;

public class Ticket {

	private Passenger passenger;
	private Train train;
	private Date travellingDate;
	private RailwayStation from;
	private RailwayStation to;

	public Ticket(Train train, Passenger passenger, RailwayStation from, RailwayStation to) {
		this.train = train;
		this.from = from;
		this.to = to;
		this.passenger = passenger;
	}

	public Train getTrain() {
		return train;
	}
	@Override
	public String toString() {
		return "-----------------------" + "IRCTC" + "-----------------------\n" + "| passenger name : "
				+ passenger.getName() + "\n| On boarding date : " + train.getOnBoardingDate() + "\n| Train : "
				+ train.getName() + "\n| From : " + from.getLocation() + "\n| To : " + to.getLocation()
				+ "\n| seat number : " + passenger.getPassengerID() + passenger.getAlottedBerth()
				+ "\n|\thave a happy journey!" + "\n----------------------------------------------------";
	}

	public Passenger getPassenger() {
		return passenger;
	}

}
