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

	public User(int userID, String name, String mobileNumber, String skills, String qualification, String email,
			int experience) {
		this.skills = skills;
		this.name = name;
		this.email = email;
		this.experience = experience;
		this.userID = userID;
		this.qualification = qualification;
		this.mobileNumber = mobileNumber;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setExperience(int experience) {
		this.experience = experience;
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
