package com.scheduleinterview;

import com.scheduleinterview.ScheduleInterviewModel.ScheduleInterviewControllerModelCallBack;

public class ScheduleInterviewController
		implements ScheduleInterviewControllerCallBack, ScheduleInterviewControllerModelCallBack {

	private ScheduleInterviewModelCallBack scheduleInterviewModel;
	private ScheduleInterviewViewCallBack scheduleInterviewView;

	public ScheduleInterviewController(ScheduleInterviewView scheduleInterviewView) {
		this.scheduleInterviewView = scheduleInterviewView;
		this.scheduleInterviewModel = new ScheduleInterviewModel(this);
	}

}
