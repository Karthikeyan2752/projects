package com.hrlogin;

import com.model.HR;
import com.repository.DB;

public class HRLoginViewModel {

	private HRLoginView hRLoginView;

	public HRLoginViewModel(HRLoginView hRLoginView) {
		this.hRLoginView = hRLoginView;
	}


	public HR sigin(String name, String email, String companyName, String password, String mobileNumber) {
		return DB.getInstance().hRSignin(name, email, companyName, password, mobileNumber);
	}


	public HR login(int userID, String password) {
		return DB.getInstance().getHR(userID, password);
	}

}
