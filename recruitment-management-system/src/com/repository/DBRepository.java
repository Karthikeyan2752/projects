package com.repository;

import java.util.ArrayList;
import java.util.List;

import com.dto.Admin;
import com.dto.Credentials;

public class DBRepository {

	private static DBRepository dBRInstance;

	private List<Credentials> adminCredentials = new ArrayList<Credentials>();
	private Admin admin = null;

	private DBRepository() {

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
}

