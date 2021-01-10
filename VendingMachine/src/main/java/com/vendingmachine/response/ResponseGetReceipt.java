package com.vendingmachine.response;

import com.vendingmachine.dto.ReceiptDTO;

public class ResponseGetReceipt {
	private ReceiptDTO receipt;

	public ReceiptDTO getReceipt() {
		return receipt;
	}

	public void setReceipt(ReceiptDTO receipt) {
		this.receipt = receipt;
	}
}
