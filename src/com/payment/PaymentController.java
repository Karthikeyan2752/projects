package com.payment;

import com.dataclasses.Flight;
import com.payment.PaymentModel.PaymentControllerModelControllerCallBack;

public class PaymentController implements PaymentControllerModelControllerCallBack, PaymentControllerCallBack {

	private PaymentViewCallBack paymentView;
	private PaymentModelCallBack paymentModel;

	public PaymentController(PaymentView paymentView) {
		this.paymentView = paymentView;
		this.paymentModel = new PaymentModel(this);
	}



	@Override
	public boolean payment(Flight flight, int amount, int count) {
		return paymentModel.payment(flight, amount, count);
	}



}
