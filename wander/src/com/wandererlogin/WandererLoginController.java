package com.wandererlogin;

import java.util.Date;

import com.dto.Wanderer;
import com.wandererlogin.WandererLoginModel.WandererLoginControllerModelCallBack;

public class WandererLoginController
		implements WandererLoginControllerCallBack, WandererLoginControllerModelCallBack {
	private WandererLoginViewCallBack wandererLoginView;
	private WandererLoginModelCallBack wandererLoginModel;
	
	public WandererLoginController(WandererLoginViewCallBack wandererLoginView) {
		this.wandererLoginView = wandererLoginView;
		this.wandererLoginModel = new WandererLoginModel(this);
	}

	@Override
	public Wanderer login(int userId, String password) {
		return wandererLoginModel.login(userId, password);
	}

	@Override
	public Wanderer signUp(String name, String email, String mobile, String bio, Date dOB, String password) {
		return wandererLoginModel.signUp(name, email, mobile, bio, dOB, password);
	}

}
