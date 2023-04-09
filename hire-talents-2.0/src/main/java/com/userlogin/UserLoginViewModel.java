package com.userlogin;

import com.model.User;
import com.repository.DB;

public class UserLoginViewModel {

	public User userLogin(String email, String password) {
		return DB.getInstance().getUser(email, password);
	}

	public User userSignin(String name, String email, String qualification, String password, String mobileNumber,
			String skills, int experience, String location, String about) {
		return DB.getInstance().createAndGetUser(name, email, qualification, password, mobileNumber, skills,
				experience, location, about);
	}

	public int getAppliedJobsCount(int userID) {
		return DB.getInstance().getAppliedJobsCount(userID);
	}

	public int getSelectedJobsCount(int userID) {
		return DB.getInstance().getSelectedJobsCount(userID);
	}
}
