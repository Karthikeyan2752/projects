package com.dataclasses;

public class Ticket {

	private int ticketNumber;
	private Airport from;
	private Airport to;
	private String passsengerName;

	public Ticket(int ticketNumber, Airport from, Airport to, String passsengerName) {
		this.ticketNumber = ticketNumber;
		this.from = from;
		this.to = to;
		this.passsengerName = passsengerName;
	}
	
	@Override
	public String toString() {		
		return "passenger name : " + passsengerName + "\nfrom : " + from.getLocation() + "\nto : " + to.getLocation();
	}

}
