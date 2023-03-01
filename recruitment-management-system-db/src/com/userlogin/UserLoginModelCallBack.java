package com.userlogin;

import java.util.List;

import com.dto.User;

public interface UserLoginModelCallBack {

	User userLogin(int userID, String password);

	User userSignin(String name, String password, String mobileNumber, List<String> skills);

}
