package com.reneg.debtscommand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reneg.debtscommand.business.DebtBusiness;
import com.reneg.debtscommand.domain.entity.Debt;

@RestController
@RequestMapping("debts")
public class DebtController {
	
	@Autowired
	private DebtBusiness debtBusiness;
		
	@PostMapping
	public Debt save(@RequestBody Debt debt){
		return this.debtBusiness.save(debt);
	}
	
	@PutMapping
	public Debt update(@RequestBody Debt debt){
		return this.debtBusiness.update(debt);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		this.debtBusiness.delete(id);
		return ResponseEntity.noContent().build();
	}


}
