package com.userlogin;

import com.model.User;
import com.repository.DB;

public class UserLoginViewModel {

	public User userLogin(int userID, String password) {
		return DB.getInstance().getUser(userID, password);
	}

	public User userSignin(String name, String email, String qualification, String password, String mobileNumber,
			String skills, int experience) {
		return DB.getInstance().createAndGetUser(name, email, qualification, password, mobileNumber, skills,
				experience);
	}
}
