package com.vendingmachine.dto;

import java.util.Map;

import com.vendingmachine.enumeration.PaymentTypes;

public class PaymentDTO {
	private Boolean result;
	private PaymentTypes paymentType;
	private Map<String, Integer> coinReturned;
	private Map<String, Integer> banknoteReturned;

	public Boolean getResult() {
		return result;
	}

	public PaymentTypes getPaymentType() {
		return paymentType;
	}

	public Map<String, Integer> getCoinReturned() {
		return coinReturned;
	}

	public Map<String, Integer> getBanknoteReturned() {
		return banknoteReturned;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public void setPaymentType(PaymentTypes paymentType) {
		this.paymentType = paymentType;
	}

	public void setCoinReturned(Map<String, Integer> coinReturned) {
		this.coinReturned = coinReturned;
	}

	public void setBanknoteReturned(Map<String, Integer> banknoteReturned) {
		this.banknoteReturned = banknoteReturned;
	}
}
