package com.dto;

public class User {

	private int userID;
	private String name;
	private String password;
	private long mobileNumber;

	public User(int userID, String name, String password, long mobileNumber) {
		super();
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

}
