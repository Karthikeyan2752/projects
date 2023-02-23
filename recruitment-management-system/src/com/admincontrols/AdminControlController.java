package com.admincontrols;

import com.admincontrols.AdminControlModel.AdminControlModelControllerCallBack;

public class AdminControlController implements AdminControlControllerCallBack, AdminControlModelControllerCallBack {

	private AdminControlViewCallBack adminControlView;
	private AdminControlModelCallBack adminControlModel;
	
	public AdminControlController(AdminControlView adminControlView) {
		this.adminControlView=adminControlView;
		this.adminControlModel = new AdminControlModel(this);
	}

}
