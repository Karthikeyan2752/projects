package com.ticket.cancelling;

import com.repository.DBRepository;

public class TicketCancellingModel implements TicketCancellingModelCallBack {

	private TicketCancellingController ticketCancellingController;

	public TicketCancellingModel(TicketCancellingController ticketCancellingController) {
		this.ticketCancellingController = ticketCancellingController;
	}

	public boolean cancelTicket(int ticketId) {
		boolean status = DBRepository.getInstance().cancelTicket(ticketId);
		return status;
	}

}
