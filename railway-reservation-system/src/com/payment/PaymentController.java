package com.payment;

import com.payment.PaymentModel.PaymentModelControllerCallBack;

public class PaymentController implements PaymentControllerCallBack, PaymentModelControllerCallBack {
	
	private PaymentModelCallBack paymentModel;
	private PaymentViewCallBack paymentView;

	public PaymentController(PaymentView paymentView) {
		this.paymentView = paymentView;
		this.paymentModel = new PaymentModel(this);
	}



}
