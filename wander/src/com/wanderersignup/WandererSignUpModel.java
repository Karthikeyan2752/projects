package com.wanderersignup;

public class WandererSignUpModel implements WandererSignUpModelCallBack {

	private WandererSignUpControllerCallBack candidateSignUpController;

	public WandererSignUpModel(WandererSignUpController candidateSignUpController) {
		this.candidateSignUpController = candidateSignUpController;
	}

	public interface WandererSignUpControllerModelCallBack {

	}
}
