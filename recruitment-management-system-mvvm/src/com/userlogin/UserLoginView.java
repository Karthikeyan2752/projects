package com.userlogin;

import java.util.Scanner;

import com.apply.ApplyView;
import com.model.User;
import com.util.UIValidator;

public class UserLoginView {

	private UserLoginViewModel userLoginViewModel;
	Scanner scanner = new Scanner(System.in);

	public UserLoginView() {
		this.userLoginViewModel = new UserLoginViewModel(this);
	}

	public void userLogin() {
		System.out.println("Enter your user ID : ");
		int userID = UIValidator.getIntChoice();
		System.out.println("Enter your password : ");
		String password = scanner.next();

		User user = userLoginViewModel.userLogin(userID, password);
		if (user == null) {
			System.out.println("Something went wrong! Try again");
			userLogin();
		}
		System.out.println("\tWelcome " + user.getName() + "\n");
		ApplyView applyView = new ApplyView();
		applyView.displayControls(user);

	}

	public void signUp() {
		String name = UIValidator.getName();
		String mobileNumber = UIValidator.getMobileNumber();
		System.out.println("Enter your password : ");
		String password = scanner.next();
		System.out.println("Enter the your skills : (separated by commas)\n");
		String skills = scanner.next();
		System.out.println("Enter your email id : \n");
		String email = scanner.next();
		System.out.println("Enter your highest qualification : \n");
		String qualification = scanner.next();
		User user = userLoginViewModel.userSignin(name, email, qualification, password, mobileNumber, skills);
		System.out.println("Given details : ");
		System.out.println("Note the User ID for further login");
		System.out.println(user.toString());
		ApplyView applyView = new ApplyView();
		applyView.displayControls(user);
	}
}
