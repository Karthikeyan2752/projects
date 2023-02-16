package com.setupairport;

public class SetUpAirportController implements SetUpAirportControllerCallBack, SetUpAirportModelControllerCallBack {
	private SetUpAirportViewCallBack setUpAirportView;
	private SetUpAirportModelCallBack setUpAirportModel;

	public SetUpAirportController(SetUpAirportViewCallBack setUpAirportView) {
		this.setUpAirportView = setUpAirportView;
		this.setUpAirportModel = new SetUpAirportModel(this);
	}

	@Override
	public void AirportExist(String libraryName, String libAddress) {
		setUpAirportModel.libraryExistInDB(libraryName, libAddress);
	}

	@Override
	public void setUpSuccess(String airportName) {
		setUpAirportView.setUpSuccess(airportName);

	}

}
