package com.wandererlogin;

import java.util.Date;
import java.util.Scanner;

import com.model.Wanderer;
import com.util.UIValidator;
import com.wanderercontrols.WandererControlView;

public class WandererLoginView {
	private WandererLoginViewModel wandererLoginViewModel;
	private Scanner scanner = new Scanner(System.in);

	public WandererLoginView() {
		this.wandererLoginViewModel = new WandererLoginViewModel(this);
	}

	public void start() {
		System.out.println("Already a wanderer ?\nEnter 1 for login:\n");
		System.out.println("New User ? \nEnter 2 for sign up and start wandering \n");
		System.out.println("Enter 0 to exit\n");
		byte choice = UIValidator.getChoice();
		switch (choice) {
		case 1:
			login();
			break;
		case 2:
			signUp();
			break;
		default:
			return;

		}

	}
	public void login() {
		System.out.println("\t>>> Wanderer Login page >>>\n");
		System.out.println("Enter your user ID : \n");
		int userId = UIValidator.getIntChoice();
		System.out.println("Enter your password : \n");
		String password = scanner.next();
		Wanderer wanderer = wandererLoginViewModel.login(userId, password);
		WandererControlView controls = new WandererControlView();
		if (wanderer != null) {
			controls.displayControls(wanderer);
		}
		start();

	}

	public void signUp() {
		System.out.println("\t>>> Wanderer sign up page >>>\n");
		String name = UIValidator.getName();
		String email = UIValidator.getEmail();
		String mobile = UIValidator.getMobileNumber();
		System.out.println("Enter your bio that will display in your profile : ");
		String bio = scanner.next();
		System.out.println("Enter your DOB : (mm/dd/yyyy)");
		Date dOB = UIValidator.getDateFromUser();
		System.out.println("Enter your password : ");
		String password = scanner.next();
		Wanderer wanderer = wandererLoginViewModel.signUp(name, email, mobile, bio, dOB, password);
		WandererControlView controls = new WandererControlView();
		if (wanderer != null) {
			System.out.println("Your details : \n");
			System.out.println(wanderer.toString());
			controls.displayControls(wanderer);
		}
		start();
	}

}
