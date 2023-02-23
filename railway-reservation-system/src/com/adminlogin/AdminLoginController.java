package com.adminlogin;

import com.adminlogin.AdminLoginModel.AdminLoginModelControllerCallBack;
import com.dto.Admin;

public class AdminLoginController implements AdminLoginControllerCallBack, AdminLoginModelControllerCallBack {

	private AdminLoginViewCallBack adminLoginView;
	private AdminLoginModelCallBack adminLoginModel;

	public AdminLoginController(AdminLoginView adminLoginView) {
		this.adminLoginView = adminLoginView;
		this.adminLoginModel = new AdminLoginModel(this);
	}

	@Override
	public void checkCredentials(String userName, String password) {
		adminLoginModel.checkCredentials(userName, password);
	}

	@Override
	public void loginSuccess(Admin adminUser) {
		adminLoginView.loginSuccess(adminUser);
	}

	@Override
	public void loginFailiure(String errorMessage) {
		adminLoginView.loginFailed(errorMessage);
	}


}
