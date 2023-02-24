package com.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dto.Admin;
import com.dto.Credentials;
import com.dto.Passenger;
import com.dto.RailwayStation;
import com.dto.Ticket;
import com.dto.Train;
import com.dto.User;

public class DBRepository {

	private static DBRepository dBRInstance;
	private static int earnings = 0;
	private static int passengerID = 100;
	private List<Credentials> adminCredentials = new ArrayList<Credentials>();
	private static List<Passenger> passengers = new ArrayList<>();
	private static List<Ticket> tickets = new ArrayList<>();
	private static List<Train> trains = new ArrayList<>();
	private Set<User> users = new HashSet<>();
	private static Map<RailwayStation, List<Train>> trainMap = new HashMap<>();
	private Admin admin = null;

	private DBRepository() {

	}

	public static DBRepository getInstance() {
		if (dBRInstance == null) {
			dBRInstance = new DBRepository();
			dBRInstance.initialSetup();
		}
		return dBRInstance;
	}

	public Admin checkValidUser(String userName, String password) {
		for (Credentials credential : adminCredentials) {
			if (credential.getUserName().equals(userName) && credential.getPassword().equals(password)) {
				return credential;
			}
		}
		return null;
	}

	private void initialSetup() {
		adminCredentials.add(new Credentials("1", "admin", "123"));
		users.add(new User(1, "karthi", "123", 78713938));
		RailwayStation chennai = new RailwayStation("chennai");
		RailwayStation tanjore = new RailwayStation("tanjore");
		Train chennaiExpress = new Train("chennaiExpress", chennai, tanjore, new Date("02/25/2023"));
		chennaiExpress.setTicketPrice(100);
		trains.add(chennaiExpress);
		trainMap.put(chennai, trains);
	}

	public User createAndGetUser(int userID, String name, String password, long mobileNumber) {
		User user = new User(userID, name, password, mobileNumber);
		users.add(user);
		return user;
	}

	public User getUser(int userID, String password) {
		for (User user : users) {
			if (user.getUserID() == userID && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public Ticket bookTicket(String name, byte age, String prefferedBerth, Date date, String depature, String arrival) {

		for (Train train : trains) {
			if (arrival.equals(train.getTo().getLocation()) && depature.equals(train.getFrom().getLocation())
					&& train.getOnBoardingDate().compareTo(date) == 0) {
				if (age >= 60 && prefferedBerth != "L") {
					System.out.println("IRCTC take care of senior citizens,\nSo we are preffering you lower berth");
					prefferedBerth = "L";
				}
				return book(passengerID++, name, age, prefferedBerth, train);
			}
		}
		return null;
	}

	private Ticket book(int passengerID, String name, byte age, String prefferedBerth, Train train) {

		if (train.getAvailableLowerBerth() > 0 && prefferedBerth == "L") {
			train.setAvailableLowerBerth(train.getAvailableLowerBerth() - 1);
			return createPassengerAndGetTicket(passengerID, name, age, prefferedBerth, train);

		} else if (train.getAvailableMiddleBerth() > 0 && prefferedBerth == "M") {
			train.setAvailableMiddleBerth(train.getAvailableMiddleBerth() - 1);
			return createPassengerAndGetTicket(passengerID, name, age, prefferedBerth, train);

		} else if (train.getAvailableLowerBerth() > 0 && prefferedBerth == "U") {
			train.setAvailableUpperBerth(train.getAvailableUpperBerth() - 1);
			return createPassengerAndGetTicket(passengerID, name, age, prefferedBerth, train);
		} else if (train.getAvailableLowerBerth() > 0) {
			train.setAvailableLowerBerth(train.getAvailableLowerBerth() - 1);
			return createPassengerAndGetTicket(passengerID, name, age, "L", train);

		} else if (train.getAvailableMiddleBerth() > 0) {
			train.setAvailableMiddleBerth(train.getAvailableMiddleBerth() - 1);
			return createPassengerAndGetTicket(passengerID, name, age, "M", train);

		} else if (train.getAvailableLowerBerth() > 0) {
			train.setAvailableUpperBerth(train.getAvailableUpperBerth() - 1);
			return createPassengerAndGetTicket(passengerID, name, age, "U", train);

		} else if (train.getAvailableRAC() > 0) {
			train.setAvailableRAC(train.getAvailableRAC() - 1);
			Ticket ticket = createPassengerAndGetTicket(passengerID, name, age, "RAC", train);
			train.getRACListQueue().add(ticket);
			return ticket;

		} else if (train.getWaitingList() > 0) {
			train.setWaitingList(train.getWaitingList() - 1);
			Ticket ticket = createPassengerAndGetTicket(passengerID, name, age, "Waiting List", train);
			train.getWaitingListQueue().add(ticket);
			return ticket;

		}
		return null;
	}

	private Ticket createPassengerAndGetTicket(int passengerID, String name, byte age, String prefferedBerth,
			Train train) {

		Passenger passenger = new Passenger(passengerID, name, age, prefferedBerth);
		passengers.add(passenger);
		train.setNumberOfPassengers(train.getNumberOfPassengers() + 1);
		Ticket ticket = new Ticket(train, passenger, train.getFrom(), train.getTo());
		tickets.add(ticket);

		return ticket;
	}

	private void incrementBerthCount(Train train, String berth) {
		if (berth == "L") {
			train.setAvailableLowerBerth(train.getAvailableLowerBerth() + 1);
		} else if (berth == "M") {
			train.setAvailableMiddleBerth(train.getAvailableMiddleBerth() + 1);
		} else if (berth == "U") {
			train.setAvailableUpperBerth(train.getAvailableUpperBerth() + 1);
		} else if (berth == "RAC") {
			train.setAvailableRAC(train.getAvailableRAC() + 1);
		} else if (berth == "Waiting List") {
			train.setWaitingList(train.getWaitingList() + 1);
		}

	}
	public String cancelTicket(int ticketID) {
		String result = "Ticket ID not found ! ";
		for (Ticket ticket : tickets) {
			Passenger passenger = ticket.getPassenger();
			Train train = ticket.getTrain();
			if (passenger.getPassengerID() == ticketID) {
				String berth = passenger.getAlottedBerth();
				passengers.remove(passenger);
				tickets.remove(ticket);
				System.out.println("dakdk");
				bookTicketForRACAndWaitingList(train, passenger, berth);
				return result = "Ticket cancelled successfully";
			}
		}

		return result;
	}

	private void bookTicketForRACAndWaitingList(Train train, Passenger passenger, String berth) {
		if (!train.getRACListQueue().isEmpty()) {
			Ticket ticket = train.getRACListQueue().remove();
			ticket.getPassenger().setAlottedBerth(passenger.getAlottedBerth());
		} else if (!train.getWaitingListQueue().isEmpty()) {
			Ticket ticket = train.getWaitingListQueue().remove();
			ticket.getPassenger().setAlottedBerth("RAC");
			train.getRACListQueue().add(ticket);
		} else {
			incrementBerthCount(train, berth);
		}

	}

	public Ticket getTicket(int passengerID) {
		for (Ticket ticket : tickets) {
			if (ticket.getPassenger().getPassengerID() == passengerID) {
				return ticket;
			}
		}
		return null;
	}

	public List<Passenger> viewPassengerDetails() {
		return passengers;
	}

	public void setupRailwayStation(String location) {
		trainMap.put(new RailwayStation(location), new ArrayList<>());
	}

	public void addTrains(String name, int seats, String depature, String arrival, Date date) {
		RailwayStation from = null;
		RailwayStation to = null;
		for (RailwayStation station : trainMap.keySet()) {
			if (station.getLocation() == depature) {
				from = station;
			} else {
				if (station.getLocation() == arrival) {
					to = station;
				}
			}
		}

		Train train = null;
		if (from != null && to != null) {
			train = new Train(name, from, to, date);
			train.setAvailableLowerBerth(seats);
			train.setAvailableMiddleBerth(seats);
			train.setAvailableRAC(seats);
			train.setWaitingList(seats);
			trainMap.get(from).add(train);
			trains.add(train);
		}


	}

	public String deleteTrains(String name) {
		String result = "Train not found";
		for (List<Train> t : trainMap.values()) {
			for (Train train : t) {
				if (train.getName().equals(name)) {
				if (train.getNumberOfPassengers() == 0) {
					trains.remove(train);
					return result = "Train Removed successfully!";
				}
				result = "Can't remove because there are " + train.getNumberOfPassengers() + " in train";
			}
		}
	}
		return result;
	}

	public List<Train> viewAvailableTrains() {
		return trains;
	}

	public int payment(String depature, String arrival, Date date, int numberOfTickets, boolean tatkal) {
		for (Train train : trains) {
			if (arrival.equals(train.getTo().getLocation()) && depature.equals(train.getFrom().getLocation())
					&& train.getOnBoardingDate().compareTo(date) == 0) {
				boolean available = isAvailable(train, numberOfTickets);
				if (available && tatkal) {
					earnings = earnings + (train.getTicketPrice() + (train.getTicketPrice() / 2)) * numberOfTickets;
					return (train.getTicketPrice() + (train.getTicketPrice() / 2)) * numberOfTickets;
				} else if (available) {
					earnings = earnings + train.getTicketPrice() * numberOfTickets;
					return train.getTicketPrice() * numberOfTickets;
				}
			}
		}
		return -1;
	}

	private boolean isAvailable(Train train, int numberOfTickets) {
		int totalTickets = 0;
		totalTickets += train.getAvailableLowerBerth();
		totalTickets += train.getAvailableMiddleBerth();
		totalTickets += train.getAvailableUpperBerth();
		totalTickets += train.getAvailableRAC();
		totalTickets += train.getWaitingList();

		return numberOfTickets <= totalTickets;
	}

	public Train viewAvailableSeats(String name) {
		for (Train train : trains) {
			if (train.getName().equals(name)) {
				return train;
			}
		}
		return null;
	}
}

