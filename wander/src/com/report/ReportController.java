package com.report;

import com.report.ReportModel.ReportModelControllerCallBack;

public class ReportController implements ReportControllerCallBack, ReportModelControllerCallBack {

	private ReportViewCallBack reportView;
	private ReportModelCallBack reportModel;

	public ReportController(ReportView reportView) {
		this.reportView = reportView;
		this.reportModel = new ReportModel(this);
	}

}
