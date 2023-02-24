package com.hrlogin;

import com.dto.HR;

public interface HRLoginControllerCallBack {

	HR signin(String name, String companyName, String password, long mobileNumber);

	HR login(int userID, String password);

}
