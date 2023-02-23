package com.getticket;

import com.dto.Ticket;
import com.repository.DBRepository;

public class GetTicketModel implements GetTicketModelCallBack {

	private GetTicketControllerCallBack getTicketController;

	public GetTicketModel(GetTicketControllerCallBack getTicketController) {
		this.getTicketController = getTicketController;
	}

	public interface GetTicketModelControllerCallBack {

	}

	@Override
	public Ticket getTicket(int passengerID) {
		return DBRepository.getInstance().getTicket(passengerID);

	}
}
