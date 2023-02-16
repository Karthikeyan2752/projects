package com.setupairport;

import java.util.Scanner;

public class SetUpAirportView {
	private Scanner scanner = new Scanner(System.in);
	private SetUpAirportControllerCallBack setUpAirportController;

	public SetUpAirportView() {
		this.setUpAirportController = new SetUpAirportController(this);
	}

	public void create() {
		addAirportName();
	}

	@Override
	public void setUpFailed(String airportName) {
		System.out.println("Airport " + airportName + " already exist in database");
	}

	@Override
	public void setUpSuccess(String airportName) {
		System.out.println("Airport " + airportName + " is successfully added");
	}

	private void addAirportName() {
		System.out.println("Enter the name of the Airport:");
		String airportName = scanner.nextLine();
		System.out.println("Enter the address of the Airport: ");
		String airportLocation = scanner.nextLine();
		setUpAirportController.airportExist(airportName, airportLocation);
	}

}
