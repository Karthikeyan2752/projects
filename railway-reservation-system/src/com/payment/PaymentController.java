package com.payment;

import java.util.Date;

import com.payment.PaymentModel.PaymentModelControllerCallBack;

public class PaymentController implements PaymentControllerCallBack, PaymentModelControllerCallBack {
	
	private PaymentModelCallBack paymentModel;
	private PaymentViewCallBack paymentView;

	public PaymentController(PaymentView paymentView) {
		this.paymentView = paymentView;
		this.paymentModel = new PaymentModel(this);
	}

	@Override
	public int payment(String depature, String arrival, Date date, int numberOfTickets, boolean tatkal) {
		return paymentModel.payment(depature, arrival, date, numberOfTickets, tatkal);

	}


}
