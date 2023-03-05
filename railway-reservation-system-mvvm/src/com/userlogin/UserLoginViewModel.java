package com.userlogin;

import com.model.User;
import com.repository.DBRepository;

public class UserLoginViewModel {

	private UserLoginView userLoginView;

	public UserLoginViewModel(UserLoginView userLoginView) {
		this.userLoginView = userLoginView;
	}

	public User userLogin(int userID, String password) {
		return DBRepository.getInstance().getUser(userID, password);
	}

	public User userSignin(int userID, String name, String password, long mobileNumber) {
		return DBRepository.getInstance().createAndGetUser(userID, name, password, mobileNumber);
	}
}
