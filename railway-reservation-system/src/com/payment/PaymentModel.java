package com.payment;

public class PaymentModel implements PaymentModelCallBack{

	private PaymentControllerCallBack paymentController;
	
	public PaymentModel(PaymentController paymentController) {
		this.paymentController=paymentController;
	}

	public interface PaymentModelControllerCallBack {

	}

}
