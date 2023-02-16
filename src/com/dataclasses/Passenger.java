package com.dataclasses;

public class Passenger {

	private String name;
	private String mobileNumber;
	private String address;
	private String aadhaar;
	private Ticket ticket;
	private int amountPaid;

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Passenger(String name, String mobileNumber, String address, String aadhaar, Ticket ticket) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.ticket = ticket;
		this.aadhaar = aadhaar;
	}

	@Override
	public String toString() {
		return name + "\t" + mobileNumber + "\t" + address + "\t" + aadhaar;
	}


}
