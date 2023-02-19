package com.ticket.cancelling;

public class TicketCancellingController implements TicketCancellingControllerCallBack {

	private TicketCancellingModel ticketCancellingModel;
	private TicketCancellingView ticketCancellingView;

	public TicketCancellingController(TicketCancellingView ticketCancellingView) {
		this.ticketCancellingView = ticketCancellingView;
		this.ticketCancellingModel = new TicketCancellingModel(this);
	}

	public boolean cancelTicket(int ticketId) {

		return ticketCancellingModel.cancelTicket(ticketId);
	}

}
