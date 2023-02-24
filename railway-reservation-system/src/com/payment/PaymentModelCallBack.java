package com.payment;

import java.util.Date;

public interface PaymentModelCallBack {

	int payment(String depature, String arrival, Date date, int numberOfTickets, boolean tatkal);

}
