package com.dataclasses;

import java.util.Date;

public class Flight {

	private Airport from;
	private Airport to;
	private String model;
	private int capacity = 20;
	private int tatkalCapacity = 10;
	private String flightName;
	private int ticketPrice = 3000;
	private Date onBoardingDate;

	public int getTatkalCapacity() {
		return tatkalCapacity;
	}

	public void setTatkalCapacity(int tatkalCapacity) {
		this.tatkalCapacity = tatkalCapacity;
	}

	public Date getOnBoardingDate() {
		return onBoardingDate;
	}

	@SuppressWarnings("deprecation")
	public void setOnBoardingDate(String date) {
		this.onBoardingDate = new Date(date);
	}

	public Airport getFrom() {
		return from;
	}


	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public Airport getTo() {
		return to;
	}

	public Flight(String flightName, Airport from, Airport to) {
		this.flightName = flightName;
		this.from = from;
		this.to = to;
	}

	public String getFlightName() {
		return flightName;
	}

	public String getModel() {
		return model;
	}


	private void setFromLocation(Airport from) {
		this.from = from;
	}

	private void setToLocation(Airport to) {
		this.to = to;
	}


}
