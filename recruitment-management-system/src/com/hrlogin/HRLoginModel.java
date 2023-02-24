package com.hrlogin;

import com.dto.HR;
import com.repository.DBRepository;

public class HRLoginModel implements HRLoginModelCallBack {

	private HRLoginControllerCallBack hRLoginController;

	public HRLoginModel(HRLoginControllerCallBack hrLoginController) {
		this.hRLoginController = hrLoginController;
	}

	@Override
	public HR sigin(String name, String companyName, String password, long mobileNumber) {
		return DBRepository.getInstance().hRSignin(name, companyName, password, mobileNumber);
	}

	@Override
	public HR login(int userID, String password) {
		return DBRepository.getInstance().hRLogin(userID, password);
	}

}
