package com.ticketcancelling;

import com.repository.DBRepository;

public class TicketCancellingViewModel {

	private TicketCancellingView ticketCancellingView;

	public TicketCancellingViewModel(TicketCancellingView ticketCancellingView) {
		this.ticketCancellingView = ticketCancellingView;
	}

	public String cancelTicket(int ticketID) {
		return DBRepository.getInstance().cancelTicket(ticketID);
	}
}
