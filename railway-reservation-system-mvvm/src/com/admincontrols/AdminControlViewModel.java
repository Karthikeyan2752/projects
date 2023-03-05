package com.admincontrols;

import java.util.Date;
import java.util.List;

import com.model.Passenger;
import com.model.Train;
import com.repository.DBRepository;

public class AdminControlViewModel {

	private AdminControlView adminControlView;

	public AdminControlViewModel(AdminControlView adminControlView) {
		this.adminControlView = adminControlView;
	}

	public interface AdminControlModelControllerCallBack {

	}


	public List<Passenger> viewPassengerDetails() {
		return DBRepository.getInstance().viewPassengerDetails();
	}

	public void setupRailwayStation(String location) {
		DBRepository.getInstance().setupRailwayStation(location);

	}

	public void addTrains(String name, int seats, String depature, String arrival, Date date) {
		DBRepository.getInstance().addTrains(name, seats, depature, arrival, date);

	}

	public String deleteTrains(String name) {
		return DBRepository.getInstance().deleteTrains(name);
	}

	public List<Train> viewAvailableTrains() {
		return DBRepository.getInstance().viewAvailableTrains();
	}

	public Train viewAvailableSeats(String name) {
		return DBRepository.getInstance().viewAvailableSeats(name);
	}

}
