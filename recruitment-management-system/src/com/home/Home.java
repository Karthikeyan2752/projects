package com.home;

import java.util.Scanner;

import com.adminlogin.AdminLoginView;
import com.hrlogin.HRLoginView;
import com.userlogin.UserLoginView;

public class Home {

	public static void main(String[] args) {
		start();
	}

	private static void start() {
		System.out.println("\tWELCOME TO  RESILIENT RECRUITMENT SERVICES\n");
		System.out.println("Enter 1 for admin login : \n");
		System.out.println("Enter 2 for HR login :\n");
		System.out.println("Enter 3 for user login :\n");
		System.out.println("Enter 4 for HR sign in: \n");
		System.out.println("Enter 5 for user sign in : \n");
		System.out.println("Enter 0 to exit\n");
		UserLoginView userLoginView = new UserLoginView();
		HRLoginView hrLoginView = new HRLoginView();
		AdminLoginView adminLoginView = new AdminLoginView();
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			adminLoginView.start();
			break;
		case 2:
			hrLoginView.hRLogin();
			break;
		case 3:
			userLoginView.userLogin();
			break;
		case 4:
			hrLoginView.signUp();
			break;
		case 5:
			userLoginView.signUp();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			start();

		}
		start();
	}

}
