package com.report;

import java.util.Scanner;

public class ReportView implements ReportViewCallBack {

	private ReportControllerCallBack reportController;
	private Scanner scanner = new Scanner(System.in);

	public ReportView() {
		this.reportController = new ReportController(this);
	}

}
