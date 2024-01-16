package com.abc.das.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.das.dto.PaymentDto;
import com.abc.das.entity.Appointment;
import com.abc.das.entity.Payment;
import com.abc.das.exception.PaymentNotFoundException;
import com.abc.das.repository.IPaymentRepository;

@Service
public class IPaymentServiceImpl implements IPaymentService {
	
	@Autowired
    private IPaymentRepository iPaymentRepository;

   @Override
  public PaymentDto addPayment (PaymentDto paymentdto) {
	   /*
	   Payment payment = new Payment();

	   payment.setPaymentId(paymentdto.getPaymentId());
	   payment.setTotalPayment(paymentdto.getTotalPayment());
	   
	   payment.setPaymentDate(paymentdto.getPaymentDate());
	   
	   payment.setModeOfPayment(paymentdto.getModeOfPayment());

	   
       Payment newPayment = iPaymentRepository.save(payment);
       
       PaymentDto newDto = new PaymentDto();
       
       newDto.setPaymentId(newPayment.getPaymentId());
       
       newDto.setTotalPayment(newPayment.getTotalPayment());
       
       newDto.setPaymentDate(newPayment.getPaymentDate());
       
       newDto.setModeOfPayment(newPayment.getModeOfPayment());
       
       return newDto;
       */
	   Payment payment = new Payment();
	   payment.setPaymentId(paymentdto.getPaymentId());
	   payment.setTotalPayment(paymentdto.getTotalPayment());
	   
	   payment.setPaymentDate(paymentdto.getPaymentDate());
	   
	   payment.setModeOfPayment(paymentdto.getModeOfPayment());
	   
	   Appointment appointment = new Appointment();
	return paymentdto;
	   
	   
	   
  }

@Override
public Payment getTotalPayment(int paymentId)throws PaymentNotFoundException {
	
	 Optional<Payment> optionalPayment = iPaymentRepository.findById(paymentId);
     if(optionalPayment.isEmpty()) {
         throw new PaymentNotFoundException("Payment Not Found with id: "+paymentId);
      
     }
      Payment payment = optionalPayment.get();
     return payment;
}


}
