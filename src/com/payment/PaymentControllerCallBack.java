package com.payment;

import com.dataclasses.Flight;

public interface PaymentControllerCallBack {

	boolean payment(Flight flight, int amount, int count);

}
