package com.ticketcancelling;

import com.repository.DBRepository;

public class TicketCancellingModel implements TicketCancellingModelCallBack {

	private TicketCancellingControllerCallBack ticketCancellingController;

	public TicketCancellingModel(TicketCancellingControllerCallBack ticketCancellingController) {
		this.ticketCancellingController = ticketCancellingController;
	}

	public interface TicketCancellingModelControllerCallBack {

		String cancelTicket(int ticketID);

	}

	@Override
	public String cancelTicket(int ticketID) {
		return DBRepository.getInstance().cancelTicket(ticketID);
	}
}
