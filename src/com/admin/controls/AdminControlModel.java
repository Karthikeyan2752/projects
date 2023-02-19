package com.admin.controls;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dataclasses.Airport;
import com.dataclasses.Flight;
import com.dataclasses.Passenger;
import com.repository.DBRepository;

public class AdminControlModel implements AdminControlModelCallBack {

	private AdminControlController adminControlController;

	public AdminControlModel(AdminControlController adminControlController) {
		this.adminControlController = adminControlController;
	}


	@Override
	public void displayFlights() {
		Set<Flight> flights = DBRepository.getInstance().getFlights();
		for (Flight flight : flights) {
			System.out.println(
					flight.getFlightName() + " -> " + flight.getFrom().toString() + " to " + flight.getTo().toString());
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
		System.out.println("Total number of tickets booked till now : " + count);
	}


	@Override
	public void displayFlightsInAirports() {
		Map<Airport, List<Flight>> entries = DBRepository.getInstance().getEntry();
		for (Map.Entry<Airport, List<Flight>> entry : entries.entrySet()) {
			System.out.print(entry.getKey().getLocation() + " -> ");
			for (Flight flightName : entry.getValue()) {
				System.out.print(flightName.getFlightName() + "  ");
			}
			System.out.println();
		}

	}

}
