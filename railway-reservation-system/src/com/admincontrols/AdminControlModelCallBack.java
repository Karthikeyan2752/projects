package com.admincontrols;

import java.util.Date;
import java.util.List;

import com.dto.Passenger;
import com.dto.Train;

public interface AdminControlModelCallBack {

	List<Passenger> viewPassengerDetails();

	void addTrains(String name, int seats, String depature, String arrival, Date date);

	void setupRailwayStation(String location);

	String deleteTrains(String name);

	List<Train> viewAvailableTrains();

	Train viewAvailableSeats(String name);

}
