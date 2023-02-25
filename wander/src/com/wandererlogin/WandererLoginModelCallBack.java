package com.wandererlogin;

import java.util.Date;

import com.dto.Wanderer;

public interface WandererLoginModelCallBack {

	Wanderer login(int userId, String password);

	Wanderer signUp(String name, String email, String mobile, String bio, Date dOB, String password);

}
