package com.candidatesignup;

public class CandidateSignUpModel implements CandidateSignUpModelCallBack {

	private CandidateSignUpControllerCallBack candidateSignUpController;

	public CandidateSignUpModel(CandidateSignUpController candidateSignUpController) {
		this.candidateSignUpController = candidateSignUpController;
	}

	public interface CandidateLoginControllerModelCallBack {

	}
}
