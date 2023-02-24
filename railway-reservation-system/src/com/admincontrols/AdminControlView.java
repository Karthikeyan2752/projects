package com.admincontrols;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dto.Passenger;
import com.dto.Train;

public class AdminControlView implements AdminControlViewCallBack {

	private AdminControlControllerCallBack adminControlController;
	private Scanner scanner = new Scanner(System.in);

	public AdminControlView() {
		this.adminControlController = new AdminControlController(this);
	}

	public void displayControls() {
		System.out.println("Please enter 1 to add trains : ");
		System.out.println("Please enter 2 to delete trains : ");
		System.out.println("Please enter 3 to set up Railway Station : ");
		System.out.println("Please enter 4 to view available trains : ");
		System.out.println("Please enter 5 to view the available seats in trains : ");
		System.out.println("Please enter 6 to view passengers details : ");
		System.out.println("Enter 0 to exit");
		getChoices();
	}

	private void getChoices() {
		byte choice = scanner.nextByte();
		switch (choice) {
		case 1:
			addTrains();
			break;
		case 2:
			deleteTrains();
			break;
		case 3:
			setupRailwayStation();
			break;
		case 4:
			viewAvailableTrains();
			break;
		case 5:
			viewAvailableSeats();
			break;
		case 6:
			viewPassengerDetails();
			break;
		case 0:
			System.out.println("\tTHANK YOU\nExitting....");
			break;
		default:
			displayControls();
		}
	}

	private void viewAvailableTrains() {
		List<Train> trains = adminControlController.viewAvailableTrains();
		for (Train train : trains) {
			System.out.println(train.toString());
		}
		displayControls();

	}

	private void viewPassengerDetails() {
		List<Passenger> passengers = adminControlController.viewPassengerDetails();
		for (Passenger passenger : passengers) {
			System.out.println(passenger.toString());
		}
		displayControls();
	}

	private void viewAvailableSeats() {
		System.out.println("Please enter the name of train : ");
		String name = scanner.next();
		Train train = adminControlController.viewAvailableSeats(name);
		System.out.println("Available lower berths        : " + train.getAvailableLowerBerth());
		System.out.println("Available middle berths       : " + train.getAvailableMiddleBerth());
		System.out.println("Available upper berths        : " + train.getAvailableUpperBerth());
		System.out.println("Available RAC berths          : " + train.getAvailableRAC());
		System.out.println("Available Waiting list slots  : " + train.getWaitingList());
		displayControls();

	}

	private void setupRailwayStation() {
		System.out.println("Please enter the location of railway station : ");
		String location = scanner.next();
		adminControlController.setupRailwayStation(location);
		displayControls();

	}

	private void addTrains() {
		System.out.println("Please enter the name of train : ");
		String name = scanner.next();
		System.out.println("Please enter the number of seats in train : ");
		int seats = scanner.nextInt();
		System.out.println("Please enter the depature railwaySation : ");
		String depature = scanner.next();
		System.out.println("Please enter the arrival railwaySation : ");
		String arrival = scanner.next();
		Date date = getDateFromUser();
		adminControlController.addTrains(name, seats, depature, arrival, date);
		displayControls();

	}

	private void deleteTrains() {
		System.out.println("Please Enter the name of the train : ");
		String name = scanner.next();
		String result = adminControlController.deleteTrains(name);
		System.out.println(result);
		displayControls();
	}
	private Date getDateFromUser() {
		System.out.println("Please enter your depature date : (mm/dd/yyy)");
		String dateString = scanner.next();
		Date date = null;
		try {
			date = new Date(dateString);
			return date;
		} catch (Exception e) {
			System.out.println("Please enter correct date : ");
			return getDateFromUser();
		}
	}

}
