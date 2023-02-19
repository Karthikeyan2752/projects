package com.payment;

import com.dataclasses.Flight;
import com.repository.DBRepository;

public class PaymentModel implements PaymentModelCallBack {

	private PaymentControllerModelControllerCallBack paymentController;

	public PaymentModel(PaymentControllerModelControllerCallBack paymentController) {
		this.paymentController = paymentController;
	}

	@Override
	public boolean payment(Flight flight, int amount, int count) {
		return DBRepository.getInstance().makePayment(amount, flight, count);
	}

	public interface PaymentControllerModelControllerCallBack {

		boolean payment(Flight flight, int amount, int count);

	}
}


