package com.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dataclasses.Admin;
import com.dataclasses.Airport;
import com.dataclasses.Credentials;
import com.dataclasses.Flight;
import com.dataclasses.Passenger;
import com.dataclasses.Ticket;

public class DBRepository {
	private static DBRepository flightDBInstance;
	private static int totalTickets = 0;
	private static int totalAmount = 0;
	private static List<Credentials> adminCredentials = new ArrayList<>();
	private static List<Passenger> passengers = new ArrayList<>();
	private static Set<Flight> flights = new HashSet<>();
	private static Set<Ticket> tickets = new HashSet<>();
	private Admin currentAdminUser = null;
	private static Map<Airport, List<Flight>> allFlights = new HashMap<>();

	private DBRepository() {
	}

	public static DBRepository getInstance() {
		if (flightDBInstance == null) {
			flightDBInstance = new DBRepository();
			flightDBInstance.initialSetup();
		}
		return flightDBInstance;
	}

	private void initialSetup() {
		adminCredentials.add(new Credentials("1", "admin", "123"));
		Airport chennai = new Airport("Chennai");
		Airport mumbai = new Airport("Mumbai");
		Airport malaysiya = new Airport("Malaysiya");
		Airport beijing = new Airport("Beijing");
		Airport delhi = new Airport("Delhi");
		Flight flight1 = new Flight("eagle1", chennai, mumbai);
		Flight flight3 = new Flight("MH370", malaysiya, beijing);
		Flight flight2 = new Flight("eagle2", chennai, delhi);
		flight1.setOnBoardingDate("02/20/2023");
		flight3.setOnBoardingDate("03/08/2023");
		flight2.setOnBoardingDate("03/01/2023");

		flights.add(flight2);
		flights.add(flight1);
		flights.add(flight3);
		allFlights.put(malaysiya, List.of(flight3));
		allFlights.put(chennai, List.of(flight1, flight2));

	}

	public Admin checkValidUser(String userName, String password) {
		for (Credentials credential : adminCredentials) {
			if (credential.getUserName().equals(userName) && credential.getPassword().equals(password)) {
				return credential;
			}
		}
		return null;
	}

	public Flight searchFlight(String origin, String destination, Date date) {
		for (Flight flight : flights) {
			if (flight.getFrom().getLocation().equals(origin) && flight.getTo().getLocation().equals(destination)
					&& flight.getCapacity() > 0 && checkDate(flight, date)) {
				flight.setCapacity(flight.getCapacity() - 1);
				return flight;
			} else if (flight.getFrom().getLocation().equals(origin) && flight.getTo().getLocation().equals(destination)
					&& flight.getTatkalCapacity() > 0 && checkDate(flight, date)) {
				flight.setTatkalCapacity(flight.getTatkalCapacity() - 1);
				return flight;
			}
		}
		return null;
	}

	private boolean checkDate(Flight flight, Date date) {
		try {
			if (flight.getOnBoardingDate().compareTo(date) == 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Invalid Date!");
			return false;
		}
		return false;
	}

	public void addPassenger(Passenger passenger, Flight flight, Ticket ticket) {
		passengers.add(passenger);
		tickets.add(ticket);
		totalTickets++;
	}

	public void addFlight(Airport airport, Flight flight) {

		if (allFlights.containsKey(airport)) {
			allFlights.get(airport).add(flight);
		} else {
			allFlights.put(airport, List.of(flight));
		}
	}

	public int getTicketCount() {
		return totalTickets;
	}

	public List<Passenger> getPassengerDetails() {
		return passengers;
	}

	public int totalRevenue() {
		return totalAmount;
	}

	public Set<Airport> getAirports() {

		return allFlights.keySet();
	}

	public Set<Flight> getFlights() {

		return flights;
	}

	public Map<Airport, List<Flight>> getEntry() {
		return allFlights;
	}

	public boolean makePayment(int amount, Flight flight, int count) {
		if (flight.getTicketPrice() * count == amount) {
			totalAmount += amount;
			return true;
		}
		return false;
	}

	public boolean cancelTicket(int ticketId) {
		for (Ticket ticket : tickets) {
			if (ticket.getId() == ticketId) {
				removePassengerFromDB(ticketId);
				Flight flight = ticket.getFlight();
				tickets.remove(ticket);
				int cancellationCharge = flight.getTicketPrice() / 2;
				totalAmount -= cancellationCharge;
				totalTickets--;

				if (ticketId <= 20) {
					flight.setCapacity(flight.getCapacity() + 1);
				}

				return true;
			}
		}
		return false;
	}

	private void removePassengerFromDB(int ticketId) {
		for (Passenger p : passengers) {
			if (p.getTicket().getId() == ticketId) {
				passengers.remove(p);
				return;
			}
		}

	}


}
