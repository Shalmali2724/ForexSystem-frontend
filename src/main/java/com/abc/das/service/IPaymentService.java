package com.abc.das.service;

import com.abc.das.dto.PaymentDto;
import com.abc.das.entity.Payment;

public interface IPaymentService {

	
	
	Payment getTotalPayment(int paymentId);
	//public Payment getPaymentById(int paymentId);
	PaymentDto addPayment(PaymentDto paymentdto);
	
}
