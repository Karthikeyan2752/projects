package com.wandererlogin;

import java.util.Date;

import com.dto.Wanderer;
import com.repository.DBRepository;

public class WandererLoginModel implements WandererLoginModelCallBack {

	private WandererLoginControllerCallBack wandererLoginController;

	public WandererLoginModel(WandererLoginController wandererLoginController) {
		this.wandererLoginController = wandererLoginController;
	}

	public interface WandererLoginControllerModelCallBack {

	}

	@Override
	public Wanderer login(int userId, String password) {
		return DBRepository.getInstance().login(userId, password);
	}

	@Override
	public Wanderer signUp(String name, String email, String mobile, String bio, Date dOB, String password) {
		return DBRepository.getInstance().signUp(name, email, mobile, bio, dOB, password);
	}
}
