package com.admincontrols;

import java.util.Date;
import java.util.List;

import com.admincontrols.AdminControlModel.AdminControlModelControllerCallBack;
import com.dto.Passenger;
import com.dto.Train;

public class AdminControlController implements AdminControlControllerCallBack, AdminControlModelControllerCallBack {

	private AdminControlViewCallBack adminControlView;
	private AdminControlModelCallBack adminControlModel;
	
	public AdminControlController(AdminControlViewCallBack adminControlView) {
		this.adminControlView=adminControlView;
		this.adminControlModel = new AdminControlModel(this);
	}

	@Override
	public List<Passenger> viewPassengerDetails() {
		return adminControlModel.viewPassengerDetails();
	}

	@Override
	public Train viewAvailableSeats(String name) {
		return adminControlModel.viewAvailableSeats(name);
	}

	@Override
	public void setupRailwayStation(String location) {
		adminControlModel.setupRailwayStation(location);

	}

	@Override
	public void addTrains(String name, int seats, String depature, String arrival, Date date) {
		adminControlModel.addTrains(name, seats, depature, arrival, date);

	}

	@Override
	public String deleteTrains(String name) {
		return adminControlModel.deleteTrains(name);
	}

	@Override
	public List<Train> viewAvailableTrains() {
		return adminControlModel.viewAvailableTrains();
	}

}
