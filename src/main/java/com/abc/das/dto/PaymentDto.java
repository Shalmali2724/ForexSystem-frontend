package com.abc.das.dto;

import java.time.LocalDate;

public class PaymentDto {

	private int paymentId;
	private float totalPayment;
	private LocalDate paymentDate;
	private String modeOfPayment;
	private AppointmentDto appointDto;

	public AppointmentDto getAppointDto() {
		return appointDto;
	}

	public void setAppointDto(AppointmentDto appointDto) {
		this.appointDto = appointDto;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public float getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(float totalPayment) {
		this.totalPayment = totalPayment;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

}
