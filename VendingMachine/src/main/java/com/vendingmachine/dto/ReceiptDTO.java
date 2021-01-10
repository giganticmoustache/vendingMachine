package com.vendingmachine.dto;

import java.util.Map;

public class ReceiptDTO {
	private String productName;
	private Integer count;
	private String paymentType;
	private Map<String, Integer> coinMap;
	private Map<String, Integer> banknoteMap;

	public String getProductName() {
		return productName;
	}

	public Integer getCount() {
		return count;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public Map<String, Integer> getCoinMap() {
		return coinMap;
	}

	public Map<String, Integer> getBanknoteMap() {
		return banknoteMap;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public void setCoinMap(Map<String, Integer> coinMap) {
		this.coinMap = coinMap;
	}

	public void setBanknoteMap(Map<String, Integer> banknoteMap) {
		this.banknoteMap = banknoteMap;
	}
}
