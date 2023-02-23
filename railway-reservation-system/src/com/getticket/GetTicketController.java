package com.getticket;

import com.dto.Ticket;
import com.getticket.GetTicketModel.GetTicketModelControllerCallBack;

public class GetTicketController implements GetTicketControllerCallBack, GetTicketModelControllerCallBack {

	private GetTicketModelCallBack getTicketModel;
	private GetTicketViewCallBack getTicketView;

	public GetTicketController(GetTicketView getTicketView) {
		this.getTicketView = getTicketView;
		this.getTicketModel = new GetTicketModel(this);
	}

	@Override
	public Ticket getTicket(int passengerID) {
		return getTicketModel.getTicket(passengerID);
	}

}
