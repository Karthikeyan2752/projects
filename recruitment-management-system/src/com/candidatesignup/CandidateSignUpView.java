package com.candidatesignup;

import java.util.Scanner;

public class CandidateSignUpView implements CandidateSignUpViewCallBack {
	private CandidateSignUpControllerCallBack candidateSignUpController;
	private Scanner scanner = new Scanner(System.in);

	public CandidateSignUpView() {
		this.candidateSignUpController = new CandidateSignUpController(this);
	}


}
