package com.reneg.debtsquery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reneg.debtsquery.business.DebtBusiness;
import com.reneg.debtsquery.domain.entity.Debt;

@RestController
@RequestMapping("debts")
public class DebtController {
	
	@Autowired
	private DebtBusiness debtBusiness;
		
	@GetMapping("{account}")
	public ResponseEntity<List<Debt>> findByAccount(@PathVariable String account) {  
		return ResponseEntity.ok(this.debtBusiness.getDebitByAccount(account));			
	}
	
	@GetMapping
	public ResponseEntity<List<Debt>> findByAccount(@RequestParam List<Long> ids) {  
		return ResponseEntity.ok(this.debtBusiness.getDebitByIdIn(ids));			
	}

}
