package com.userlogin;

import com.dto.User;
import com.repository.DB;

public class UserLoginModel implements UserLoginModelCallBack {

	private UserLoginControllerModelCallBack userLoginController;

	public UserLoginModel(UserLoginController userLoginController) {
		this.userLoginController = userLoginController;
	}

	public interface UserLoginControllerModelCallBack {

		User userLogin(int userID, String password);

		User userSignin(String name, String email, String qualification, String password, String mobileNumber,
				String skills);
	}

	@Override
	public User userLogin(int userID, String password) {
		return DB.getInstance().getUser(userID, password);
	}

	@Override
	public User userSignin(String name, String email, String qualification, String password, String mobileNumber,
			String skills) {
		return DB.getInstance().createAndGetUser(name, email, qualification, password, mobileNumber, skills);
	}
}
