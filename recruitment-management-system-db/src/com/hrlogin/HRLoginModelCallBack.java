package com.hrlogin;

import com.dto.HR;

public interface HRLoginModelCallBack {

	HR sigin(String name, String companyName, String password, String mobileNumber);

	HR login(int userID, String password);

}
