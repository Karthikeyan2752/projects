package com.adminlogin;

import com.model.Admin;
import com.repository.DBRepository;

public class AdminLoginViewModel  {

	private AdminLoginView adminLoginView;

	public AdminLoginViewModel(AdminLoginView adminLoginView) {
		this.adminLoginView = adminLoginView;
	}

	public void checkCredentials(String userName, String password) {
		Admin adminUser = DBRepository.getInstance().checkValidUser(userName, password);
		if (adminUser != null) {
			adminLoginView.loginSuccess(adminUser);
		} else {
			adminLoginView.loginFailed("\nInvalid Credentials. Please try again!\n");
		}

	}

}
