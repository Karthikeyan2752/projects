package com.userlogin;

import com.dto.User;
import com.userlogin.UserLoginModel.UserLoginControllerModelCallBack;

public class UserLoginController implements UserLoginControllerModelCallBack, UserLoginControllerCallBack {

	private UserLoginViewCallBack userLoginView;
	private UserLoginModelCallBack userLoginModel;

	public UserLoginController(UserLoginView userLoginView) {
		this.userLoginView = userLoginView;
		this.userLoginModel = new UserLoginModel(this);
	}

	@Override
	public User userLogin(int userID, String password) {
		return userLoginModel.userLogin(userID, password);
	}

	@Override
	public User userSignin(String name, String email, String qualification, String password, String mobileNumber,
			String skills) {
		return userLoginModel.userSignin(name, email, qualification, password, mobileNumber, skills);
	}


}
