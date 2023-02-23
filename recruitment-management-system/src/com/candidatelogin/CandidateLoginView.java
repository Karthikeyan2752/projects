package com.candidatelogin;

import java.util.Scanner;

public class CandidateLoginView implements CandidateLoginViewCallBack {
	private CandidateLoginControllerCallBack candidateLoginController;
	private Scanner scanner = new Scanner(System.in);

	public CandidateLoginView() {
		this.candidateLoginController = new CandidateLoginController(this);
	}


}
