package com.userlogin;

import java.util.List;

import com.dto.User;

public interface UserLoginControllerCallBack {

	User userLogin(int userID, String password);

	User userSignin(String name, String password, long mobileNumber, List<String> skills);

}
