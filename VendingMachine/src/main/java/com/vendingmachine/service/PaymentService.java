package com.vendingmachine.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.vendingmachine.dto.PaymentDTO;
import com.vendingmachine.enumeration.Banknotes;
import com.vendingmachine.enumeration.Coins;
import com.vendingmachine.enumeration.PaymentTypes;

@Service
public class PaymentService {
	public List<PaymentTypes> getPaymentTypes() {
		return Arrays.asList(PaymentTypes.values());
	}
	
	public PaymentDTO makePayment(PaymentTypes paymentType, BigDecimal amount, BigDecimal price) {
		PaymentDTO payment = new PaymentDTO();
		payment.setPaymentType(paymentType);
		BigDecimal remainingAmount = amount.subtract(price);
		switch (paymentType) {
		case CONTACTLESS_CREDITCARD:
			payment.setResult(Boolean.TRUE);
			break;
		case CREDITCARD:
			payment.setResult(Boolean.TRUE);
			break;
		case COIN:
			Map<String, Integer> map = new HashMap<>();
			remainingAmount = remainingAmount.setScale(2);
			while (remainingAmount.compareTo(BigDecimal.ZERO) > 0) {
				if (remainingAmount.compareTo(Coins.ONE.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Coins.ONE.getValue().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					map.put(Coins.ONE.name(), remainingAmount.divide(Coins.ONE.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				} else if (remainingAmount.compareTo(Coins.FIFTY.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Coins.FIFTY.getValue().setScale(2)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					map.put(Coins.FIFTY.name(), remainingAmount.divide(Coins.FIFTY.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				} else if (remainingAmount.compareTo(Coins.TWENTYFIVE.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Coins.TWENTYFIVE.getValue().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					map.put(Coins.TWENTYFIVE.name(), remainingAmount.divide(Coins.TWENTYFIVE.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				} else if (remainingAmount.compareTo(Coins.TEN.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Coins.TEN.getValue().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					map.put(Coins.TEN.name(), remainingAmount.divide(Coins.TEN.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				} else if (remainingAmount.compareTo(Coins.FIVE.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Coins.FIVE.getValue().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					map.put(Coins.FIVE.name(), remainingAmount.divide(Coins.FIVE.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				}
			}
			payment.setCoinReturned(map);
			payment.setResult(Boolean.TRUE);
			break;
		case BANKNOTE:
			Map<String, Integer> coinMap = new HashMap<>();
			Map<String, Integer> banknoteMap = new HashMap<>();
			remainingAmount = remainingAmount.setScale(2);
			while (remainingAmount.compareTo(BigDecimal.ZERO) > 0) {
				if (remainingAmount.compareTo(Banknotes.HUNDRED.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Banknotes.HUNDRED.getValue().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					banknoteMap.put(Banknotes.HUNDRED.name(), remainingAmount.divide(Banknotes.HUNDRED.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				} else if (remainingAmount.compareTo(Banknotes.FIFTY.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Banknotes.FIFTY.getValue().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					banknoteMap.put(Banknotes.FIFTY.name(), remainingAmount.divide(Banknotes.FIFTY.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				} else if (remainingAmount.compareTo(Banknotes.TWENTY.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Banknotes.TWENTY.getValue().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					banknoteMap.put(Banknotes.TWENTY.name(), remainingAmount.divide(Banknotes.TWENTY.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				} else if (remainingAmount.compareTo(Banknotes.TEN.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Banknotes.TEN.getValue().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					banknoteMap.put(Banknotes.TEN.name(), remainingAmount.divide(Banknotes.TEN.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				} else if (remainingAmount.compareTo(Banknotes.FIVE.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Banknotes.FIVE.getValue().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					banknoteMap.put(Banknotes.FIVE.name(), remainingAmount.divide(Banknotes.FIVE.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				} else if (remainingAmount.compareTo(Coins.ONE.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Coins.ONE.getValue().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					coinMap.put(Coins.ONE.name(), remainingAmount.divide(Coins.ONE.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				} else if (remainingAmount.compareTo(Coins.FIFTY.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Coins.FIFTY.getValue().setScale(2)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					coinMap.put(Coins.FIFTY.name(), remainingAmount.divide(Coins.FIFTY.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				} else if (remainingAmount.compareTo(Coins.TWENTYFIVE.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Coins.TWENTYFIVE.getValue().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					coinMap.put(Coins.TWENTYFIVE.name(), remainingAmount.divide(Coins.TWENTYFIVE.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				} else if (remainingAmount.compareTo(Coins.TEN.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Coins.TEN.getValue().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					coinMap.put(Coins.TEN.name(), remainingAmount.divide(Coins.TEN.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				} else if (remainingAmount.compareTo(Coins.FIVE.getValue().setScale(2, RoundingMode.HALF_UP)) >= 0) {
					BigDecimal temp = remainingAmount.remainder(Coins.FIVE.getValue().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
					remainingAmount = remainingAmount.subtract(temp);
					coinMap.put(Coins.FIVE.name(), remainingAmount.divide(Coins.FIVE.getValue().setScale(2, RoundingMode.HALF_UP)).intValue());
					remainingAmount = temp;
				}
			}
			payment.setCoinReturned(coinMap);
			payment.setBanknoteReturned(banknoteMap);
			payment.setResult(Boolean.TRUE);
			break;
		default:
			payment.setResult(Boolean.FALSE);
			break;
		}
		return payment;
	}
}
