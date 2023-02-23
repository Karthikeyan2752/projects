package com.wandererlogin;

public class WandererLoginModel implements WandererLoginModelCallBack {

	private WandererLoginControllerCallBack wandererLoginController;

	public WandererLoginModel(WandererLoginController wandererLoginController) {
		this.wandererLoginController = wandererLoginController;
	}

	public interface WandererLoginControllerModelCallBack {

	}
}
