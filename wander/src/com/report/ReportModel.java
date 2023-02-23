package com.report;

public class ReportModel implements ReportModelCallBack {

	private ReportModelControllerCallBack reportController;

	public ReportModel(ReportController reportController) {
		this.reportController = reportController;
	}

	public interface ReportModelControllerCallBack {

	}

}
