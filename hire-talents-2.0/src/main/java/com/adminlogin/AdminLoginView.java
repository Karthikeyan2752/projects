package com.adminlogin;

import java.util.Scanner;

import com.admincontrols.AdminControlView;
import com.model.Admin;

public class AdminLoginView {

	private AdminLoginViewModel adminLoginViewModel;
	private Scanner scanner = new Scanner(System.in);

	public AdminLoginView() {
		adminLoginViewModel = new AdminLoginViewModel(this);
	}

	public void start() {
		checkForLogin();
	}

	private void checkForLogin() {
		System.out.println("\t WELCOME ADMIN\n ---------------------------------");
		System.out.println("Enter User Name");
		String userName = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();
		adminLoginViewModel.checkCredentials(userName, password);
	}


	public void loginSuccess(Admin admin) {
		System.out.println("\n-->Welcome " + admin.getUserName() + "<--\n");
		AdminControlView adminControlView = new AdminControlView();
		adminControlView.displayControls();
	}


	public void loginFailed(String errorMessage) {
		System.out.println(errorMessage);
		checkForLogin();
	}

}
