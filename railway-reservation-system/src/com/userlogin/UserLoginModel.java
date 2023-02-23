package com.userlogin;

import com.dto.User;
import com.repository.DBRepository;

public class UserLoginModel implements UserLoginModelCallBack {

	private UserLoginControllerModelCallBack userLoginController;

	public UserLoginModel(UserLoginController userLoginController) {
		this.userLoginController = userLoginController;
	}

	public interface UserLoginControllerModelCallBack {

		User userLogin(int userID, String password);

		User userSignin(int userID, String name, String password, long mobileNumber);
	}

	@Override
	public User userLogin(int userID, String password) {
		return DBRepository.getInstance().getUser(userID, password);
	}

	@Override
	public User userSignin(int userID, String name, String password, long mobileNumber) {
		return DBRepository.getInstance().createAndGetUser(userID, name, password, mobileNumber);
	}
}
