package com.scheduleinterview;

import java.util.Scanner;

public class ScheduleInterviewView implements ScheduleInterviewViewCallBack {
	
	private ScheduleInterviewControllerCallBack scheduleInterviewController;
	private Scanner scanner = new Scanner(System.in);

	public ScheduleInterviewView() {
		this.scheduleInterviewController = new ScheduleInterviewController(this);
	}

}
