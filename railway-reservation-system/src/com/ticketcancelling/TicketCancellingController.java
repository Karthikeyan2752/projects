package com.ticketcancelling;

import com.ticketcancelling.TicketCancellingModel.TicketCancellingModelControllerCallBack;

public class TicketCancellingController
		implements TicketCancellingControllerCallBack, TicketCancellingModelControllerCallBack {

	private TicketCancellingViewCallBack ticketCancellingView;
	private TicketCancellingModelCallBack ticketCancellingModel;

	public TicketCancellingController(TicketCancellingView ticketCancellingView) {
		this.ticketCancellingView = ticketCancellingView;
		this.ticketCancellingModel = new TicketCancellingModel(this);
	}

}
