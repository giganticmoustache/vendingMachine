package com.vendingmachine.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.vendingmachine.dto.BeverageDTO;
import com.vendingmachine.dto.ColdBeverageDTO;
import com.vendingmachine.dto.FoodDTO;
import com.vendingmachine.dto.HotBeverageDTO;
import com.vendingmachine.dto.ProductDTO;
import com.vendingmachine.dto.SelectionDTO;
import com.vendingmachine.enumeration.ProductStatus;
import com.vendingmachine.enumeration.ProductTypes;

@Service
public class ProductService {
	private List<ProductDTO> foods = null;
	private List<ProductDTO> beverages = null;
	
	public ProductService() {
		List<FoodDTO> foodList = new ArrayList<FoodDTO>();
		List<BeverageDTO> beverageList = new ArrayList<BeverageDTO>();
		for (int i = 0; i < 20; ++i) {
			foodList.add(new FoodDTO());
		}
		foods = Collections.unmodifiableList(foodList);
		for (int i = 0; i < 10; ++i) {
			beverageList.add(new BeverageDTO());
		}
		beverages = Collections.unmodifiableList(beverageList);
	}
	
	public List<ProductTypes> getProductTypes() {
		return Arrays.asList(ProductTypes.values());
	}
	
	public List<ProductDTO> selectProduct(@Validated SelectionDTO selection) throws Exception {
		Integer selectedItems = selection.getNumberOfSelectedItems();
		List<ProductDTO> dtoList = new ArrayList<>();
		this.checkStock(selection);
		switch (selection.getProductType()) {
		case FOOD:
			for (int i = 0; i < foods.size(); ++i) {
				if (ProductStatus.AVAILABLE.equals(foods.get(i).getStatus())) {
					foods.get(i).setStatus(ProductStatus.UNAVAILABLE);
					dtoList.add(new FoodDTO());
					--selectedItems;
					if (selectedItems.compareTo(0) == 0) {
						break;
					}
				}
			}
			break;
		case HOT_BEVERAGE:
			for (int i = 0; i < beverages.size(); ++i) {
				if (ProductStatus.AVAILABLE.equals(beverages.get(i).getStatus())) {
					beverages.get(i).setStatus(ProductStatus.UNAVAILABLE);
					HotBeverageDTO beverage = new HotBeverageDTO();
					beverage.setSugarCount(selection.getSugerCount());
					dtoList.add(beverage);
					--selectedItems;
					if (selectedItems.compareTo(0) == 0) {
						break;
					}
				}
			}
			break;
		case COLD_BEVERAGE:
			for (int i = 0; i < beverages.size(); ++i) {
				if (ProductStatus.AVAILABLE.equals(beverages.get(i).getStatus())) {
					beverages.get(i).setStatus(ProductStatus.UNAVAILABLE);
					dtoList.add(new ColdBeverageDTO());
					--selectedItems;
					if (selectedItems.compareTo(0) == 0) {
						break;
					}
				}
			}
			break;
		default:
			throw new Exception("Unknown product type!");
		}
		if (dtoList.isEmpty()) {
			throw new Exception("Out of stock!");
		}
		return dtoList;
	}
	
	private void checkStock(SelectionDTO selection) throws Exception {
		Integer avaibleProductCount = 0;
		if (ProductTypes.FOOD.equals(selection.getProductType())) {
			for (ProductDTO item : foods) {
				if (ProductStatus.AVAILABLE.equals(item.getStatus())) {
					++avaibleProductCount;
				}
			}
		} else {
			for (ProductDTO item : beverages) {
				if (ProductStatus.AVAILABLE.equals(item.getStatus())) {
					++avaibleProductCount;
				}
			}
		}
		if (avaibleProductCount.compareTo(selection.getNumberOfSelectedItems()) < 0) {
			throw new Exception("You have selected " + selection.getNumberOfSelectedItems() + " items, but only " + avaibleProductCount + " avaible!");
		}
	}
}
