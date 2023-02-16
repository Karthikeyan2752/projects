package com.login;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dataclasses.Admin;
import com.dataclasses.Airport;
import com.dataclasses.Flight;
import com.dataclasses.Passenger;
import com.repository.DBRepository;

public class LoginModel implements LoginModelCallBack{

	private LoginModelControlerCallBack loginController;
	
	public LoginModel(LoginModelControlerCallBack loginController) {
		this.loginController = loginController;
	}

	@Override
	public void checkCredentials(String userName, String password) {
		Admin adminUser = DBRepository.getInstance().checkValidUser(userName, password);
		if (adminUser !=null) {
			loginController.loginSuccess(adminUser);
		} else {
			loginController.loginFailiure("\nInvalid Credentials. Please try again!\n");
		}

	}

	public interface LoginModelControlerCallBack {

		void loginSuccess(Admin adminUser);
		void loginFailiure(String string);

	}

	@Override
	public void displayFlights() {
		Set<Flight> flights = DBRepository.getInstance().getFlights();
		for (Flight flight : flights) {
			System.out.println(
					flight.getFlightName() + " " + flight.getFrom().toString() + " to " + flight.getTo().toString());
		}

	}

	@Override
	public void displayAirports() {
		Set<Airport> airports = DBRepository.getInstance().getAirports();
		for (Airport airport : airports) {
			System.out.println(airport.toString());
		}

	}

	@Override
	public void displayPassengerDetails() {
		List<Passenger> passengers = DBRepository.getInstance().getPassengerDetails();
		for (Passenger p : passengers) {
			System.out.println(p.toString());
		}
	}

	@Override
	public void displayTicketCount() {
		int count = DBRepository.getInstance().getTicketCount();

	}

	@Override
	public void displayFlightsInAirports() {
		Map<Airport, List<Flight>> entries = DBRepository.getInstance().getEntry();
		for (Map.Entry<Airport, List<Flight>> entry : entries.entrySet()) {
			System.out.print(entry.getKey().getLocation() + " -> ");
			for (Flight flightName : entry.getValue()) {
				System.out.print(flightName.getFlightName() + " ");
			}
		}

	}
}
