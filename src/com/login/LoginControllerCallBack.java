package com.login;

public interface LoginControllerCallBack {

	void checkCredentials(String userName, String password);

	void displayFlights();

	void displayAirports();

	void displayPassengerDetails();

	void displayTicketsCount();

	void displayFlightsInAirport();
}
