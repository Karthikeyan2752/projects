package com.admincontrols;

public class AdminControlModel implements AdminControlModelCallBack {

	private AdminControlControllerCallBack adminControlController;

	public AdminControlModel(AdminControlController adminControlController) {
		this.adminControlController = adminControlController;
	}

	public interface AdminControlModelControllerCallBack {

	}

}
