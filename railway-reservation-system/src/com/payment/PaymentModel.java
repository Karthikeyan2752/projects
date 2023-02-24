package com.payment;

import java.util.Date;

import com.repository.DBRepository;

public class PaymentModel implements PaymentModelCallBack{

	private PaymentControllerCallBack paymentController;
	
	public PaymentModel(PaymentControllerCallBack paymentController) {
		this.paymentController=paymentController;
	}

	public interface PaymentModelControllerCallBack {

	}

	@Override
	public int payment(String depature, String arrival, Date date, int numberOfTickets, boolean tatkal) {
		return DBRepository.getInstance().payment(depature, arrival, date, numberOfTickets, tatkal);

	}

}
