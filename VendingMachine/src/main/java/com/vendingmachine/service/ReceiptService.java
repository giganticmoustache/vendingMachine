package com.vendingmachine.service;

import org.springframework.stereotype.Service;

import com.vendingmachine.dto.PaymentDTO;
import com.vendingmachine.dto.ReceiptDTO;
import com.vendingmachine.dto.SelectionDTO;

@Service
public class ReceiptService {
	public ReceiptDTO getReceipt(SelectionDTO selection, PaymentDTO payment) {
		ReceiptDTO receipt = new ReceiptDTO();
		receipt.setBanknoteMap(payment.getBanknoteReturned());
		receipt.setCoinMap(payment.getCoinReturned());
		receipt.setCount(selection.getNumberOfSelectedItems());
		receipt.setPaymentType(payment.getPaymentType().getName());
		receipt.setProductName(selection.getProductType().getName());
		return receipt;
	}
}
