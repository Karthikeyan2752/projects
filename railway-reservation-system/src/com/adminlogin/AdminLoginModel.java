package com.adminlogin;

import com.dto.Admin;
import com.repository.DBRepository;

public class AdminLoginModel implements AdminLoginModelCallBack {

	private AdminLoginControllerCallBack adminLoginController;

	public AdminLoginModel(AdminLoginController adminLoginController) {
		this.adminLoginController = adminLoginController;
	}

	@Override
	public void checkCredentials(String userName, String password) {
		boolean canLogin = false;
		Admin adminUser = DBRepository.getInstance().checkValidUser(userName, password);
		if (adminUser != null) {
			adminLoginController.loginSuccess(adminUser);
		} else {
			adminLoginController.loginFailiure("\nInvalid Credentials. Please try again!\n");
		}

	}

	public interface AdminLoginModelControllerCallBack {
		void loginSuccess(Admin adminUser);

		void loginFailiure(String string);
	}

}
