package com.dataclasses;

import java.util.Date;

public class Ticket {

	private int ticketNumber;
	private Airport from;
	private Airport to;
	private String passsengerName;
	private Date onBoardingDate;

	public Ticket(int ticketNumber, Airport from, Airport to, String passsengerName, Date onBoardingDate) {
		this.ticketNumber = ticketNumber;
		this.from = from;
		this.to = to;
		this.onBoardingDate = onBoardingDate;
		this.passsengerName = passsengerName;
	}
	
	@Override
	public String toString() {		
		return "Ticket Number" + ticketNumber + "passenger name : " + passsengerName + "\nfrom : " + from.getLocation()
				+ "\nto : " + to.getLocation() + "\nOn Boarding Date: " + onBoardingDate.toString();
	}

}
