package com.hrlogin;

import com.dto.HR;
import com.repository.DB;

public class HRLoginModel implements HRLoginModelCallBack {

	private HRLoginControllerCallBack hRLoginController;

	public HRLoginModel(HRLoginControllerCallBack hrLoginController) {
		this.hRLoginController = hrLoginController;
	}

	@Override
	public HR sigin(String name, String email, String companyName, String password, String mobileNumber) {
		return DB.getInstance().hRSignin(name, email, companyName, password, mobileNumber);
	}

	@Override
	public HR login(int userID, String password) {
		return DB.getInstance().getHR(userID, password);
	}

}
