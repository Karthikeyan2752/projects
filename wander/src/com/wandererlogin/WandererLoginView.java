package com.wandererlogin;

import java.util.Date;
import java.util.Scanner;

import com.dto.Wanderer;
import com.util.UIValidator;
import com.wanderercontrols.WandererControlView;

public class WandererLoginView implements WandererLoginViewCallBack {
	private WandererLoginControllerCallBack wandererLoginController;
	private Scanner scanner = new Scanner(System.in);

	public WandererLoginView() {
		this.wandererLoginController = new WandererLoginController(this);
	}

	public void login() {
		System.out.println("\t>>> Wanderer Login page >>>\n");
		System.out.println("Enter your user ID : \n");
		int userId = UIValidator.getIntChoice();
		System.out.println("Enter your password : \n");
		String password = scanner.next();
		Wanderer wanderer = wandererLoginController.login(userId, password);
		WandererControlView controls = new WandererControlView();
		if (wanderer != null) {
			controls.displayControls(wanderer);
		} else {
			login();
		}
		login();

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
		Wanderer wanderer = wandererLoginController.signUp(name, email, mobile, bio, dOB, password);
		WandererControlView controls = new WandererControlView();
		if (wanderer != null) {
			controls.displayControls(wanderer);
		} else {
			signUp();
		}
		signUp();
	}

}
