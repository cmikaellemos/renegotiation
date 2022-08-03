package com.reneg.debtscommand.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reneg.debtscommand.domain.entity.Debt;
import com.reneg.debtscommand.repository.DebtRepository;

@Service
public class DebtBusiness {
	
	@Autowired
	private DebtRepository debtRepository;
	
	public Debt save(Debt debt) {
		return this.debtRepository.save(debt.withStatus("ATRASO"));
	}
	
	public Debt update(Debt debt) {
		return this.debtRepository.save(debt);
	}
	
	public void delete(Long id) {
		this.debtRepository.deleteById(id);
	}

}
