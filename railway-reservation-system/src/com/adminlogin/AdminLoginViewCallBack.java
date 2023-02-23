package com.adminlogin;

import com.dto.Admin;

public interface AdminLoginViewCallBack {

	void loginSuccess(Admin admin);

	void loginFailed(String errorMessage);
	


}
