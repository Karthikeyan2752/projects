package com.setupairport;

import com.repository.DBRepository;

public class SetUpAirportModel implements SetUpAirportModelCallBack {

	private SetUpAirportModelControllerCallBack setupAirportController;

	public SetUpAirportModel(SetUpAirportModelControllerCallBack setupAirportController) {
		this.setupAirportController = setupAirportController;
	}

	@Override
	public void airportExistInDB(String airportName, String airportLocation) {
		if (DBRepository.getInstance().hasAirport(airportName)) {
			setupAirportController.AdditionFailed(airportName);
		} else {
			DBRepository.getInstance().addAirport(airportName, airportLocation);
			setupAirportController.libraryAddedSuccessfully(airportName);
		}

	}


}
