package com.hrlogin;

import com.dto.HR;

public class HRLoginController implements HRLoginControllerCallBack {

	private HRLoginModelCallBack hRLoginModel;
	private HRLoginViewCallBack hRLoginView;

	public HRLoginController(HRLoginViewCallBack hrLoginView) {
		this.hRLoginModel = new HRLoginModel(this);
		this.hRLoginView = hrLoginView;
	}

	@Override
	public HR signin(String name, String email, String companyName, String password, String mobileNumber) {
		return hRLoginModel.sigin(name, email, companyName, password, mobileNumber);
	}

	@Override
	public HR login(int userID, String password) {
		return hRLoginModel.login(userID, password);
	}

}
