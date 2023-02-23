package com.candidatelogin;

import com.candidatelogin.CandidateLoginModel.CandidateLoginControllerModelCallBack;

public class CandidateLoginController
		implements CandidateLoginControllerCallBack, CandidateLoginControllerModelCallBack {
	private CandidateLoginViewCallBack candidateLoginView;
	private CandidateLoginModelCallBack candidateLoginModel;
	
	public CandidateLoginController(CandidateLoginView candidateLoginView) {
		this.candidateLoginView = candidateLoginView;
		this.candidateLoginModel = new CandidateLoginModel(this);
	}

}
