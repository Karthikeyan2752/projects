package com.hrlogin;

import java.util.Scanner;

import com.dto.HR;
import com.hrcontrols.HRControlView;
import com.util.UIValidator;

public class HRLoginView implements HRLoginViewCallBack {

	private HRLoginControllerCallBack hRLoginController;
	private Scanner scanner = new Scanner(System.in);
	public HRLoginView() {
		this.hRLoginController = new HRLoginController(this);
	}

	public void hRLogin() {
		System.out.println("Enter your user ID : ");
		int userID = scanner.nextInt();
		System.out.println("Enter your password : ");
		String password = scanner.next();

		HR hr = hRLoginController.login(userID, password);
		if (hr == null) {
			System.out.println("Something went wrong! Try again");
			hRLogin();
		}
		HRControlView hRControlView = new HRControlView();
		hRControlView.displayControls(hr);
	}

	public void signUp() {

		String name = UIValidator.getName();
		String mobileNumber = UIValidator.getMobileNumber();
		System.out.println("Enter your organisation name : \n");
		String companyName = scanner.next();
		System.out.println("Enter your email id : \n");
		String email = scanner.next();
		System.out.println("Enter your password : \n");
		String password = scanner.next();
		HR hr = hRLoginController.signin(name, email, companyName, password, mobileNumber);
		if (hr == null) {
			System.out.println("Something went wrong! Try again");
			hRLogin();
		}
		System.out.println("Note the User ID for further login\n");
		System.out.println(hr.toString());
	}

}
