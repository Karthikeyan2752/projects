package com.adminlogin;

import com.dto.Admin;

public interface AdminLoginControllerCallBack {

	void checkCredentials(String userName, String password);

	void loginSuccess(Admin adminUser);

	void loginFailiure(String errorMessage);

}
