package com.getticket;

import com.model.Ticket;
import com.repository.DBRepository;

public class GetTicketViewModel {

	private GetTicketView getTicketView;

	public GetTicketViewModel(GetTicketView getTicketView) {
		this.getTicketView = getTicketView;
	}

	public Ticket getTicket(int passengerID) {
		return DBRepository.getInstance().getTicket(passengerID);

	}
}
