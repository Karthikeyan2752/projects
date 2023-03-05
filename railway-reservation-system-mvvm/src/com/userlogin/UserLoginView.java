package com.userlogin;

import java.util.Scanner;

import com.model.User;

public class UserLoginView {

	private UserLoginViewModel userLoginViewModel;
	Scanner scanner = new Scanner(System.in);

	public UserLoginView() {
		this.userLoginViewModel = new UserLoginViewModel(this);
	}

	public User userLogin() {
		System.out.println("Enter your user ID : ");
		int userID = scanner.nextInt();
		System.out.println("Enter your password : ");
		String password = scanner.next();

		return userLoginViewModel.userLogin(userID, password);
	}

	public User signUp() {
		System.out.println("Please Enter your name : ");
		String name = scanner.next();
		System.out.println("Enter your user ID : ");
		int userID = scanner.nextInt();
		System.out.println("Please enter your mobileNumber : ");
		long mobileNumber = scanner.nextLong();
		System.out.println("Enter your password : ");
		String password = scanner.next();

		return userLoginViewModel.userSignin(userID, name, password, mobileNumber);
	}
}
