package com.admin.controls;

public class AdminControlController implements AdminControlControllerCallBack {

	private AdminControlView adminControlView;
	private AdminControlModel adminControlModel;

	public AdminControlController(AdminControlView adminControlView) {
		this.adminControlView = adminControlView;
		this.adminControlModel = new AdminControlModel(this);
	}


	@Override
	public void displayFlights() {
		adminControlModel.displayFlights();

	}


	@Override
	public void displayAirports() {
		adminControlModel.displayAirports();

	}


	@Override
	public void displayPassengerDetails() {
		adminControlModel.displayPassengerDetails();

	}


	@Override
	public void displayTicketsCount() {
		adminControlModel.displayTicketCount();

	}


	@Override
	public void displayFlightsInAirports() {
		adminControlModel.displayFlightsInAirports();

	}


}
