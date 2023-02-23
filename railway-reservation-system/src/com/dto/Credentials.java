package com.dto;

public class Credentials extends Admin {
	private String password;

	public Credentials(String adminId, String adminName, String password) {
		super.setUserId(adminId);
		super.setUserName(adminName);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
