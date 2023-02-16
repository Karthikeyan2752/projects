package com.login;

import com.dataclasses.Admin;

public interface LoginViewCallBack {

	void loginSuccess(Admin adminUser);

	void loginFailed(String errorMessage);

}