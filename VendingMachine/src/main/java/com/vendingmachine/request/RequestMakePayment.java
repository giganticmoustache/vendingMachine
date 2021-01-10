package com.vendingmachine.request;

import java.math.BigDecimal;

import javax.validation.constraints.Positive;

import com.vendingmachine.enumeration.PaymentTypes;

public class RequestMakePayment {
	private PaymentTypes paymentType;
	@Positive
	private BigDecimal amount;
	@Positive
	private BigDecimal price;

	public PaymentTypes getPaymentType() {
		return paymentType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPaymentType(PaymentTypes paymentType) {
		this.paymentType = paymentType;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
