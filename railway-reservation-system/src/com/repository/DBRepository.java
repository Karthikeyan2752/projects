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

	private static int passengerID = 100;
	private List<Credentials> adminCredentials = new ArrayList<Credentials>();
	private List<Passenger> passengers = new ArrayList<>();
	private List<Ticket> tickets = new ArrayList<>();
	private List<Train> trains = new ArrayList<>();
	private Set<User> users = new HashSet<>();
	private Map<RailwayStation, List<Train>> trainMap = new HashMap<>();
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
		Train chennaiExpress = new Train("", chennai, tanjore, new Date("02/24/2023"));
		trains.add(chennaiExpress);
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
				if (age >= 60) {
					prefferedBerth = "L";
				}
				return book(name, age, prefferedBerth, train);
			}
		}
		return null;
	}

	private Ticket book(String name, byte age, String prefferedBerth, Train train) {

		if (train.getAvailableLowerBerth() > 0 && prefferedBerth == "L") {
			train.setAvailableLowerBerth(train.getAvailableLowerBerth() - 1);
			return createPassengerAndGetTicket(name, age, prefferedBerth, train);

		} else if (train.getAvailableMiddleBerth() > 0 && prefferedBerth == "M") {
			train.setAvailableMiddleBerth(train.getAvailableMiddleBerth() - 1);
			return createPassengerAndGetTicket(name, age, prefferedBerth, train);

		} else if (train.getAvailableLowerBerth() > 0 && prefferedBerth == "U") {
			train.setAvailableUpperBerth(train.getAvailableUpperBerth() - 1);
			return createPassengerAndGetTicket(name, age, prefferedBerth, train);
		} else if (train.getAvailableLowerBerth() > 0) {
			train.setAvailableLowerBerth(train.getAvailableLowerBerth() - 1);
			return createPassengerAndGetTicket(name, age, "L", train);

		} else if (train.getAvailableMiddleBerth() > 0) {
			train.setAvailableMiddleBerth(train.getAvailableMiddleBerth() - 1);
			return createPassengerAndGetTicket(name, age, "M", train);

		} else if (train.getAvailableLowerBerth() > 0) {
			train.setAvailableUpperBerth(train.getAvailableUpperBerth() - 1);
			return createPassengerAndGetTicket(name, age, "U", train);

		} else if (train.getAvailableRAC() > 0) {
			train.setAvailableRAC(train.getAvailableRAC() - 1);
			Ticket ticket = createPassengerAndGetTicket(name, age, "RAC", train);
			train.getRACListQueue().add(ticket);
			return ticket;

		} else if (train.getWaitingList() > 0) {
			train.setWaitingList(train.getWaitingList() - 1);
			Ticket ticket = createPassengerAndGetTicket(name, age, "Waiting List", train);
			train.getWaitingListQueue().add(ticket);
			return ticket;

		}
		return null;
	}

	private Ticket createPassengerAndGetTicket(String name, byte age, String prefferedBerth, Train train) {

		Passenger passenger = new Passenger(passengerID++, name, age, prefferedBerth);
		passengers.add(passenger);
		Ticket ticket = new Ticket(passenger, train.getFrom(), train.getTo());
		tickets.add(ticket);

		return ticket;
	}
}

