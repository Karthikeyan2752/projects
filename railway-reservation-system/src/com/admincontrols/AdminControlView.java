package com.admincontrols;

import java.util.Scanner;

public class AdminControlView implements AdminControlViewCallBack {

	private AdminControlControllerCallBack adminControlController;
	private Scanner scanner = new Scanner(System.in);

	public AdminControlView() {
		this.adminControlController = new AdminControlController(this);
	}

}
