package com.admincontrols;

import java.util.Date;
import java.util.List;

import com.dto.Passenger;
import com.dto.Train;
import com.repository.DBRepository;

public class AdminControlModel implements AdminControlModelCallBack {

	private AdminControlControllerCallBack adminControlController;

	public AdminControlModel(AdminControlControllerCallBack adminControlController) {
		this.adminControlController = adminControlController;
	}

	public interface AdminControlModelControllerCallBack {

	}

	@Override
	public List<Passenger> viewPassengerDetails() {
		return DBRepository.getInstance().viewPassengerDetails();
	}

	@Override
	public void setupRailwayStation(String location) {
		DBRepository.getInstance().setupRailwayStation(location);

	}

	@Override
	public void addTrains(String name, int seats, String depature, String arrival, Date date) {
		DBRepository.getInstance().addTrains(name, seats, depature, arrival, date);

	}

	@Override
	public String deleteTrains(String name) {
		return DBRepository.getInstance().deleteTrains(name);
	}

	@Override
	public List<Train> viewAvailableTrains() {
		return DBRepository.getInstance().viewAvailableTrains();
	}

	@Override
	public Train viewAvailableSeats(String name) {
		return DBRepository.getInstance().viewAvailableSeats(name);
	}

}
