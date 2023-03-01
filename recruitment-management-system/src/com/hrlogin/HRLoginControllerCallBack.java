package com.hrlogin;

import com.dto.HR;

public interface HRLoginControllerCallBack {

	HR signin(String name, String companyName, String password, String mobileNumber, String mobileNumber2);

	HR login(int userID, String password);

}
