package com.userlogin;

import java.util.List;

import com.dto.User;
import com.repository.DBRepository;

public class UserLoginModel implements UserLoginModelCallBack {

	private UserLoginControllerModelCallBack userLoginController;

	public UserLoginModel(UserLoginController userLoginController) {
		this.userLoginController = userLoginController;
	}

	public interface UserLoginControllerModelCallBack {

		User userLogin(int userID, String password);

		User userSignin(String name, String password, String mobileNumber, List<String> skills);
	}

	@Override
	public User userLogin(int userID, String password) {
		return DBRepository.getInstance().getUser(userID, password);
	}

	@Override
	public User userSignin(String name, String password, String mobileNumber, List<String> skills) {
		return DBRepository.getInstance().createAndGetUser(name, password, mobileNumber, skills);
	}
}
