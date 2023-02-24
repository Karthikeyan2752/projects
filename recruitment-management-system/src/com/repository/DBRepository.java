package com.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dto.Admin;
import com.dto.Credentials;
import com.dto.HR;
import com.dto.User;

public class DBRepository {

	private static int userID = 1;
	private static int hRUserID = 1;
	private static DBRepository dBRInstance;
	private Set<User> users = new HashSet<>();
	private Set<HR> hRs = new HashSet<>();
	private List<Credentials> adminCredentials = new ArrayList<Credentials>();
	private Admin admin = null;

	private DBRepository() {

	}

	public User getUser(int userID, String password) {
		for (User user : users) {
			if (user.getUserID() == userID && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public User createAndGetUser(String name, String password, long mobileNumber, List<String> skills) {
		User user = new User(userID++, name, password, mobileNumber, skills);
		users.add(user);
		return user;
	}

	public static DBRepository getInstance() {
		if (dBRInstance == null) {
			dBRInstance = new DBRepository();
			dBRInstance.initialSetup();
		}
		return dBRInstance;
	}

	public Admin checkValidUser(String userName, String password) {
		for (Credentials credential : adminCredentials) {
			if (credential.getUserName().equals(userName) && credential.getPassword().equals(password)) {
				return credential;
			}
		}
		return null;
	}

	private void initialSetup() {
		adminCredentials.add(new Credentials("1", "admin", "123"));
	}

	public HR hRSignin(String name, String companyName, String password, long mobileNumber) {
		HR hr = new HR(hRUserID++, name, companyName, mobileNumber);
		hr.setPassword(password);
		hRs.add(hr);
		return hr;
	}

	public HR hRLogin(int userID, String password) {
		for (HR hr : hRs) {
			if (hr.getId() == userID) {
				return hr;
			}
		}
		return null;
	}

}

