package com.userlogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.apply.ApplyView;
import com.dto.User;
import com.util.UIValidator;

public class UserLoginView implements UserLoginViewCallBack {

	private UserLoginControllerCallBack userLoginController;
	Scanner scanner = new Scanner(System.in);

	public UserLoginView() {
		this.userLoginController = new UserLoginController(this);
	}

	public void userLogin() {
		System.out.println("Enter your user ID : ");
		int userID = UIValidator.getIntChoice();
		System.out.println("Enter your password : ");
		String password = scanner.next();

		User user = userLoginController.userLogin(userID, password);
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
		System.out.println("Enter the number of skills your have : ");
		System.out.println("You can only add upto 15 skills!\n");
		int numberOfSkills = UIValidator.getIntChoiceForSkill();
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
		ApplyView applyView = new ApplyView();
		applyView.displayControls(user);
	}
}
