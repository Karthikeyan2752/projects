package com.wanderersignup;

import com.wanderersignup.WandererSignUpModel.WandererSignUpControllerModelCallBack;

public class WandererSignUpController
		implements WandererSignUpControllerCallBack, WandererSignUpControllerModelCallBack {
	private WandererSignUpViewCallBack wandererSignUpView;
	private WandererSignUpModelCallBack wandererSignUpModel;
	
	public WandererSignUpController(WandererSignUpView wandererSignUpView) {
		this.wandererSignUpView = wandererSignUpView;
		this.wandererSignUpModel = new WandererSignUpModel(this);
	}

}
