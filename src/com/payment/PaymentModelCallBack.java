package com.payment;

import com.dataclasses.Flight;

public interface PaymentModelCallBack {

	boolean payment(Flight flight, int amount, int count);

}
