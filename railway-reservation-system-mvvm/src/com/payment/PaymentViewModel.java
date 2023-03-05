package com.payment;

import java.util.Date;

import com.repository.DBRepository;

public class PaymentViewModel {

	private PaymentView paymentView;
	
	public PaymentViewModel(PaymentView paymentView) {
		this.paymentView = paymentView;
	}

	public int payment(String depature, String arrival, Date date, int numberOfTickets, boolean tatkal) {
		return DBRepository.getInstance().payment(depature, arrival, date, numberOfTickets, tatkal);

	}

}
