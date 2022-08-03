package com.reneg.debtscalculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reneg.debtscalculator.business.DebtCalculatorBusiness;
import com.reneg.debtscalculator.domain.dto.Simulation;

@RestController
@RequestMapping("")
public class DebtsCalculatorController {
	
	@Autowired
	private DebtCalculatorBusiness debtCalculatorBusiness;
		
	@GetMapping
	public ResponseEntity<List<Simulation>> simulateDebts(@RequestParam List<Long> ids) {  
		return ResponseEntity.ok(this.debtCalculatorBusiness.calculateDebtsProducts(ids));			
	}

}
