package com.admincontrols;

import java.util.List;

import com.admincontrols.AdminControlModel.AdminControlModelControllerCallBack;
import com.dto.Post;
import com.dto.Report;
import com.dto.Wanderer;

public class AdminControlController implements AdminControlControllerCallBack, AdminControlModelControllerCallBack {

	private AdminControlViewCallBack adminControlView;
	private AdminControlModelCallBack adminControlModel;
	
	public AdminControlController(AdminControlView adminControlView) {
		this.adminControlView=adminControlView;
		this.adminControlModel = new AdminControlModel(this);
	}

	@Override
	public String addReports(String reason, Post post, Wanderer wanderer) {
		return adminControlModel.addReports(reason, post, wanderer);
	}

	@Override
	public List<Report> getReports() {
		return adminControlModel.getReports();
	}

	@Override
	public String deleteAuthor(Post post, Wanderer author) {
		return adminControlModel.deleteAuthor(post, author);
	}

	@Override
	public String deletePost(Post post, Wanderer author) {
		return adminControlModel.deletePost(post, author);
	}

}
