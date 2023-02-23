package com.scheduleinterview;

public class ScheduleInterviewModel implements ScheduleInterviewModelCallBack {

	private ScheduleInterviewControllerCallBack scheduleInterviewController;

	public ScheduleInterviewModel(ScheduleInterviewController scheduleInterviewController) {
		this.scheduleInterviewController = scheduleInterviewController;
	}

	public interface ScheduleInterviewControllerModelCallBack {

	}

}
