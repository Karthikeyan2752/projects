package com.dataclasses;

public class Flight {

	private Airport from;
	private Airport to;
	private String model;
	// private List<Airport> stops;
	private int capacity = 20;
	private String flightName;

	public Airport getFrom() {
		return from;
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
