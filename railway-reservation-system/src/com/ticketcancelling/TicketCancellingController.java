package com.ticketcancelling;

import com.ticketcancelling.TicketCancellingModel.TicketCancellingModelControllerCallBack;

public class TicketCancellingController
		implements TicketCancellingControllerCallBack, TicketCancellingModelControllerCallBack {

	private TicketCancellingViewCallBack ticketCancellingView;
	private TicketCancellingModelCallBack ticketCancellingModel;

	public TicketCancellingController(TicketCancellingViewCallBack ticketCancellingView) {
		this.ticketCancellingView = ticketCancellingView;
		ticketCancellingModel = new TicketCancellingModel(this);
	}

	@Override
	public String cancelTicket(int ticketID) {
		return ticketCancellingModel.cancelTicket(ticketID);

	}

}
