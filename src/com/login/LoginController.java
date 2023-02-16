package com.login;

import com.dataclasses.Admin;
import com.login.LoginModel.LoginModelControlerCallBack;

public class LoginController implements LoginControllerCallBack, LoginModelControlerCallBack {

	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;

	public LoginController(LoginView loginView) {
		this.loginView = loginView;
		this.loginModel = new LoginModel(this);
	}

	@Override
	public void checkCredentials(String userName, String password) {
		loginModel.checkCredentials(userName,password);
	}

	@Override
	public void loginSuccess(Admin adminUser) {
		loginView.loginSuccess(adminUser);
	}

	@Override
	public void loginFailiure(String errorMessage) {
		loginView.loginFailed(errorMessage);	
	}

	@Override
	public void displayFlights() {
		loginModel.displayFlights();

	}

	@Override
	public void displayAirports() {
		loginModel.displayAirports();

	}

	@Override
	public void displayPassengerDetails() {
		loginModel.displayPassengerDetails();

	}

	@Override
	public void displayTicketsCount() {
		loginModel.displayTicketCount();

	}

	@Override
	public void displayFlightsInAirport() {
		loginModel.displayFlightsInAirports();

	}
}
