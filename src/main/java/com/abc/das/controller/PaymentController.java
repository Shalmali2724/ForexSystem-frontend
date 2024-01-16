package com.abc.das.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.das.dto.PaymentDto;
import com.abc.das.entity.Payment;
import com.abc.das.service.IPaymentService;

@RestController
public class PaymentController {
	@Autowired
	private IPaymentService iPaymentService;

	@PostMapping("/payment/save")

	public ResponseEntity<PaymentDto> addPayment(@RequestBody PaymentDto paymentdto)

	{

		PaymentDto newPayment = iPaymentService.addPayment(paymentdto);

		ResponseEntity<PaymentDto> responseEntity = new ResponseEntity<>(newPayment, HttpStatus.CREATED);//

		return responseEntity;

	}

	@GetMapping("/payment/id/{id}")
	public ResponseEntity<Payment> fetchPaymentDetails(@PathVariable("id") int paymentId) {
		Payment payment = iPaymentService.getTotalPayment(paymentId);
		ResponseEntity<Payment> responseEntity = new ResponseEntity<Payment>(payment, HttpStatus.OK);
		return responseEntity;
	}

}
