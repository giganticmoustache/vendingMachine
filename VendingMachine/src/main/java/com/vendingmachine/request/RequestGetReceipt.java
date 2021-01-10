package com.vendingmachine.request;

import com.vendingmachine.dto.PaymentDTO;
import com.vendingmachine.dto.SelectionDTO;

public class RequestGetReceipt {
	private SelectionDTO selection;
	private PaymentDTO payment;

	public SelectionDTO getSelection() {
		return selection;
	}

	public PaymentDTO getPayment() {
		return payment;
	}

	public void setSelection(SelectionDTO selection) {
		this.selection = selection;
	}

	public void setPayment(PaymentDTO payment) {
		this.payment = payment;
	}
}
