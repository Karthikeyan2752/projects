package com.admincontrols;

import java.util.Date;
import java.util.List;

import com.dto.Passenger;
import com.dto.Train;

public interface AdminControlControllerCallBack {

	List<Passenger> viewPassengerDetails();

	Train viewAvailableSeats(String name);

	void setupRailwayStation(String location);

	void addTrains(String name, int seats, String depature, String arrival, Date date);

	String deleteTrains(String name);

	List<Train> viewAvailableTrains();

}
