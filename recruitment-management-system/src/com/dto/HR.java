package com.dto;

public class HR {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String companyName;
	private String name;
	private long mobileNumber;
	private String password;


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HR(int id, String name, String companyName, long mobileNumber) {
		this.companyName = companyName;
		this.name = name;
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + companyName;
	}

}
