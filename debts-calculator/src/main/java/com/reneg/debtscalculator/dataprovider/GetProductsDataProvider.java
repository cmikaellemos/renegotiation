package com.reneg.debtscalculator.dataprovider;

import java.util.List;

import com.reneg.debtscalculator.domain.dto.Debt;
import com.reneg.debtscalculator.domain.dto.Product;

public interface GetProductsDataProvider {
	
	public List<Product> getProducts();

}
