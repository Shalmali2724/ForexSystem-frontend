package com.abc.das.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.das.dto.PaymentDto;
import com.abc.das.entity.Payment;

public interface IPaymentRepository extends JpaRepository<Payment,Integer>{

	Object save(PaymentDto payment);

	

}
