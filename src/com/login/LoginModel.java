package com.login;

import com.dataclasses.Admin;
import com.repository.DBRepository;

public class LoginModel implements LoginModelCallBack{

	private LoginModelControlerCallBack loginController;
	
	public LoginModel(LoginModelControlerCallBack loginController) {
		this.loginController = loginController;
	}

	@Override
	public void checkCredentials(String userName, String password) {
		Admin adminUser = DBRepository.getInstance().checkValidUser(userName, password);
		if (adminUser !=null) {
			loginController.loginSuccess(adminUser);
		} else {
			loginController.loginFailiure("\nInvalid Credentials. Please try again!\n");
		}

	}

	public interface LoginModelControlerCallBack {

		void loginSuccess(Admin adminUser);
		void loginFailiure(String string);

	}

	}
