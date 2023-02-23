package com.dto;

public class Passenger {

	private int passengerID;
	private String name;
	private byte age;
	private String prefferedBerth;
	private String alottedBerth;

	public String getAlottedBerth() {
		return alottedBerth;
	}

	public void setAlottedBerth(String alottedBerth) {
		this.alottedBerth = alottedBerth;
	}

	public Passenger(int passengerID, String name, byte age, String prefferedBerth) {
		this.name = name;
		this.age = age;
		this.prefferedBerth = prefferedBerth;
	}

	@Override
	public String toString() {
		return passengerID + "\t" + name + "\t" + prefferedBerth;
	}

}
