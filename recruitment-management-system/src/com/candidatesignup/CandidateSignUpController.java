package com.candidatesignup;

import com.candidatesignup.CandidateSignUpModel.CandidateLoginControllerModelCallBack;

public class CandidateSignUpController
		implements CandidateSignUpControllerCallBack, CandidateLoginControllerModelCallBack {
	private CandidateSignUpViewCallBack candidateSignUpView;
	private CandidateSignUpModelCallBack candidateSignUpModel;
	
	public CandidateSignUpController(CandidateSignUpView candidateSignUpView) {
		this.candidateSignUpView = candidateSignUpView;
		this.candidateSignUpModel = new CandidateSignUpModel(this);
	}

}
