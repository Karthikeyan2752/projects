package com.wandererlogin;

import java.util.Date;

import com.model.Wanderer;
import com.repository.DBRepository;

public class WandererLoginViewModel {

	private WandererLoginView wandererLoginView;

	public WandererLoginViewModel(WandererLoginView wandererLoginView) {
		this.wandererLoginView = wandererLoginView;
	}

	public Wanderer login(int userId, String password) {
		return DBRepository.getInstance().login(userId, password);
	}


	public Wanderer signUp(String name, String email, String mobile, String bio, Date dOB, String password) {
		return DBRepository.getInstance().signUp(name, email, mobile, bio, dOB, password);
	}
}
