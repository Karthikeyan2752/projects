package com.candidatelogin;

public class CandidateLoginModel implements CandidateLoginModelCallBack {

	private CandidateLoginControllerCallBack candidateLoginController;

	public CandidateLoginModel(CandidateLoginController candidateLoginController) {
		this.candidateLoginController = candidateLoginController;
	}

	public interface CandidateLoginControllerModelCallBack {

	}
}
