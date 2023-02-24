package com.userlogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dto.User;

public class UserLoginView implements UserLoginViewCallBack {

	private UserLoginControllerCallBack userLoginController;
	Scanner scanner = new Scanner(System.in);

	public UserLoginView() {
		this.userLoginController = new UserLoginController(this);
	}

	public User userLogin() {
		System.out.println("Enter your user ID : ");
		int userID = scanner.nextInt();
		System.out.println("Enter your password : ");
		String password = scanner.next();

		return userLoginController.userLogin(userID, password);
	}

	public void signUp() {
		System.out.println("Please Enter your name : ");
		String name = scanner.next();
		System.out.println("Please enter your mobileNumber : ");
		long mobileNumber = scanner.nextLong();
		System.out.println("Enter your password : ");
		String password = scanner.next();
		System.out.println("Enter the number of skills your have : \n");
		int numberOfSkills = scanner.nextInt();
		List<String> skills = new ArrayList<>();
		for (int i = 0; i < numberOfSkills; i++) {
			System.out.println("Enter the skill : \n");
			String skill = scanner.next();
			skills.add(skill);
		}

		User user = userLoginController.userSignin(name, password, mobileNumber, skills);
		System.out.println("Given details : ");
		System.out.println("Note the User ID for further login");
		System.out.println(user.toString());
	}
}
