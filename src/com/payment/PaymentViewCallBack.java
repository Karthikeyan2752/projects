package com.payment;

import com.dataclasses.Flight;

public interface PaymentViewCallBack {
	boolean payment(Flight flight, int count);
}
