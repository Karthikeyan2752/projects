package com.dataclasses;

public class Airport {
	private String location;
	private String name;

	public Airport(String location) {
		this.location = location;
		this.name = location + "Airport";
	}

	public String getLocation() {
		return location;
	}

}
