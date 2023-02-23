package com.adminlogin;

import java.util.Scanner;

import com.dto.Admin;

public class AdminLoginView implements AdminLoginViewCallBack {

	private AdminLoginControllerCallBack adminLoginController;
	private Scanner scanner = new Scanner(System.in);

	public AdminLoginView() {
		adminLoginController = new AdminLoginController(this);
	}

	public static void main(String[] args) {
		AdminLoginView adminLoginView = new AdminLoginView();
		adminLoginView.start();
	}

	public void start() {
		checkForLogin();
	}

	private void checkForLogin() {
		System.out.println("\tIRCTC WELCOMES YOU\n ---------------------------------");
		System.out.println("Enter User Name");
		String userName = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();
		adminLoginController.checkCredentials(userName, password);
	}

	@Override
	public void loginSuccess(Admin admin) {
		System.out.println("\n-->Welcome " + admin.getUserName() + "<--\n");
	}

	@Override
	public void loginFailed(String errorMessage) {
		System.out.println(errorMessage);
		checkForLogin();
	}

}
