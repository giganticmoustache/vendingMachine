package com.vendingmachine.response;

import com.vendingmachine.dto.PaymentDTO;

public class ResponseMakePayment {
	private PaymentDTO payment;

	public PaymentDTO getPayment() {
		return payment;
	}

	public void setPayment(PaymentDTO payment) {
		this.payment = payment;
	}
}
