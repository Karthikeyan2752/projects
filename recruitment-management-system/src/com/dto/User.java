package com.dto;

public class User {

	private int userID;
	private String name;
	private String password;
	private String mobileNumber;
	private String skills;
	private String qualification;

	public User(int userID, String name, String mobileNumber, String skills, String qualification) {
		this.skills = skills;
		this.name = name;
		this.userID = userID;
		this.qualification = qualification;
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

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "user id : " + userID + "\nname : " + name + "\nmobile : " + mobileNumber + "\n";
	}

	public String getSkills() {
		return skills;
	}

}
