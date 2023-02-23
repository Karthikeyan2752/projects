package com.userlogin;

import com.dto.User;

public interface UserLoginControllerCallBack {

	User userLogin(int userID, String password);

	User userSignin(int userID, String name, String password, long mobileNumber);

}
