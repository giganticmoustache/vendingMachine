package com.vendingmachine.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendingmachine.dto.ProductDTO;
import com.vendingmachine.request.RequestGetReceipt;
import com.vendingmachine.request.RequestMakePayment;
import com.vendingmachine.request.RequestSelectProduct;
import com.vendingmachine.response.ResponseGetPaymentTypes;
import com.vendingmachine.response.ResponseGetProductTypes;
import com.vendingmachine.response.ResponseGetReceipt;
import com.vendingmachine.response.ResponseMakePayment;
import com.vendingmachine.response.ResponseSelectProduct;
import com.vendingmachine.service.PaymentService;
import com.vendingmachine.service.ProductService;
import com.vendingmachine.service.ReceiptService;

@RestController
@RequestMapping("/vendingMachine")
public class VendingMachineRestController {
	@Autowired
	ProductService productService;

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	ReceiptService receiptService;

	@GetMapping("/getProductTypes")
	public ResponseGetProductTypes getProductTypes() {
		ResponseGetProductTypes response = new ResponseGetProductTypes();
		response.setProductTypes(this.productService.getProductTypes());
		return response;
	}

	@PostMapping("/selectProduct")
	public ResponseSelectProduct selectProduct(@Validated @RequestBody RequestSelectProduct request) throws Exception {
		ResponseSelectProduct response = new ResponseSelectProduct();
		List<ProductDTO> productList = productService.selectProduct(request.getSelection());
		response.setProductList(productList);
		BigDecimal price = null;
		if (productList != null && !productList.isEmpty()) {
			price = BigDecimal.ZERO;
			for (ProductDTO item : productList) {
				price = price.add(item.getPrice());
			}
		}
		response.setPrice(price);
		return response;
	}

	@GetMapping("/getPaymentTypes")
	ResponseGetPaymentTypes getPaymentTypes() {
		ResponseGetPaymentTypes response = new ResponseGetPaymentTypes();
		response.setPaymentTypes(paymentService.getPaymentTypes());
		return response;
	}

	@PostMapping("/makePayment")
	ResponseMakePayment makePayment(@Validated @RequestBody RequestMakePayment request) {
		ResponseMakePayment response = new ResponseMakePayment();
		response.setPayment(
				paymentService.makePayment(request.getPaymentType(), request.getAmount(), request.getPrice()));
		return response;
	}
	
	@PostMapping("/getReceipt")
	ResponseGetReceipt getReceipt(@RequestBody RequestGetReceipt request) {
		ResponseGetReceipt response = new ResponseGetReceipt();
		response.setReceipt(receiptService.getReceipt(request.getSelection(), request.getPayment()));
		return response;
	}
}
