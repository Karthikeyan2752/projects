package com.model;

public class User {

	private int userID;
	private String name;
	private String password;
	private String mobileNumber;
	private String skills;
	private String qualification;
	private String email;
	private int experience;
	private String location;
	private String about;

	public User(int userID, String name, String mobileNumber, String skills, String qualification, String email,
			int experience, String location, String about) {
		this.skills = skills;
		this.name = name;
		this.about = about;
		this.location = location;
		this.email = email;
		this.experience = experience;
		this.userID = userID;
		this.qualification = qualification;
		this.mobileNumber = mobileNumber;
	}

	private String getLocation() {
		return location;
	}

	private String getAbout() {
		return about;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getQualification() {
		return qualification;
	}

	public String getEmail() {
		return email;
	}

	public int getExperience() {
		return experience;
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
