package com.hrlogin;

import java.util.Scanner;

import com.dto.HR;

public class HRLoginView implements HRLoginViewCallBack {

	private HRLoginControllerCallBack hRLoginController;
	private Scanner scanner = new Scanner(System.in);
	public HRLoginView() {
		this.hRLoginController = new HRLoginController(this);
	}

	public HR hRLogin() {
		System.out.println("Enter your user ID : ");
		int userID = scanner.nextInt();
		System.out.println("Enter your password : ");
		String password = scanner.next();

		return hRLoginController.login(userID, password);
	}

	public void signUp() {
		System.out.println("Please Enter your name : \n");
		String name = scanner.next();
		System.out.println("Please enter your mobileNumber : \n");
		long mobileNumber = scanner.nextLong();
		System.out.println("Enter your organisation name : \n");
		String companyName = scanner.next();
		System.out.println("Enter your password : \n");
		String password = scanner.next();
		HR hr = hRLoginController.signin(name, companyName, password, mobileNumber);
		System.out.println("Note the User ID for further login\n");
		System.out.println(hr.toString());
	}

}
