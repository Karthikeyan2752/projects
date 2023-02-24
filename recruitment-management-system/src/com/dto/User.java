package com.dto;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int userID;
	private String name;
	private String password;
	private long mobileNumber;
	private List<String> skills = new ArrayList<>();

	public User(int userID, String name, String password, long mobileNumber, List<String> skills) {
		this.skills = skills;
		this.name = name;
		this.userID = userID;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}

	public int getUserID() {
		return userID;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "user id : " + userID + "\nname : " + name + "\nmobile : " + mobileNumber + "\n";
	}

}
