package com.login;

public interface LoginModelCallBack {

	void checkCredentials(String userName, String password);

	void displayFlights();

	void displayAirports();

	void displayPassengerDetails();

	void displayTicketCount();

	void displayFlightsInAirports();

}