package com.reneg.debtscalculator.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reneg.debtscalculator.dataprovider.GetDebtsByIdInDataProvider;
import com.reneg.debtscalculator.dataprovider.GetProductsDataProvider;
import com.reneg.debtscalculator.domain.dto.Debt;
import com.reneg.debtscalculator.domain.dto.Product;
import com.reneg.debtscalculator.domain.dto.Simulation;

@Service
public class DebtCalculatorBusiness {
	
	@Autowired
	private GetDebtsByIdInDataProvider getDebtsByIdInDataProvider;
	@Autowired
	private GetProductsDataProvider getProductsDataProvider;
	
	public List<Simulation> calculateDebtsProducts(List<Long> idDebts) {
		List<Product> products = this.getProductsDataProvider.getProducts();
		List<Debt> debts = this.getDebtsByIdInDataProvider.getDebtsByIdIn(idDebts);
		
		Double sum = debts.stream().map(Debt::getValue).collect(Collectors.summingDouble(Double::doubleValue));
		
		List<Simulation> simulations = new ArrayList<>();
		
		products.stream().forEach(product -> {
			double finalValue = sum + (sum * ((product.getFee()/100) * product.getMonths()));
			Simulation simulation = Simulation.builder()
				.value(sum)
				.fee(product.getFee())
				.finalValue(finalValue)
				.valueMonth(finalValue / product.getMonths())
				.months(product.getMonths())
				.build();
			simulations.add(simulation);
		});
		
		return simulations;
	}

}
