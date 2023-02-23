package com.wandererlogin;

import com.wandererlogin.WandererLoginModel.WandererLoginControllerModelCallBack;

public class WandererLoginController
		implements WandererLoginControllerCallBack, WandererLoginControllerModelCallBack {
	private WandererLoginViewCallBack wandererLoginView;
	private WandererLoginModelCallBack wandererLoginModel;
	
	public WandererLoginController(WandererLoginView wandererLoginView) {
		this.wandererLoginView = wandererLoginView;
		this.wandererLoginModel = new WandererLoginModel(this);
	}

}
