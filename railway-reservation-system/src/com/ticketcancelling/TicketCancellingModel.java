package com.ticketcancelling;

public class TicketCancellingModel implements TicketCancellingModelCallBack {

	private TicketCancellingControllerCallBack ticketCancellingController;

	public TicketCancellingModel(TicketCancellingController ticketCancellingController) {
		this.ticketCancellingController = ticketCancellingController;
	}

	public interface TicketCancellingModelControllerCallBack {

	}
}
