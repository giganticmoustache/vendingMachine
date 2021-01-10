package com.vendingmachine.response;

import java.util.List;

import com.vendingmachine.enumeration.PaymentTypes;

public class ResponseGetPaymentTypes {
	private List<PaymentTypes> paymentTypes;

	public List<PaymentTypes> getPaymentTypes() {
		return paymentTypes;
	}

	public void setPaymentTypes(List<PaymentTypes> paymentTypes) {
		this.paymentTypes = paymentTypes;
	}
}
