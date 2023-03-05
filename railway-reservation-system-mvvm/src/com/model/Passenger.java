package com.model;

public class Passenger {

	private int passengerID;
	private String name;
	private byte age;
	private String alottedBerth;

	public String getAlottedBerth() {
		return alottedBerth;
	}

	public void setAlottedBerth(String alottedBerth) {
		this.alottedBerth = alottedBerth;
	}

	public Passenger(int passengerID, String name, byte age, String prefferedBerth) {
		this.name = name;
		this.passengerID = passengerID;
		this.age = age;
		this.alottedBerth = prefferedBerth;
	}

	public int getPassengerID() {
		return passengerID;
	}

	@Override
	public String toString() {
		return passengerID + "\t" + name + "\t" + alottedBerth;
	}

	public String getName() {
		return name;
	}

	public byte getAge() {
		return age;
	}

}
