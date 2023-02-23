package com.wanderersignup;

import java.util.Scanner;

public class WandererSignUpView implements WandererSignUpViewCallBack {
	private WandererSignUpControllerCallBack candidateSignUpController;
	private Scanner scanner = new Scanner(System.in);

	public WandererSignUpView() {
		this.candidateSignUpController = new WandererSignUpController(this);
	}


}
