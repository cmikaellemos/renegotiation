package com.reneg.debtsquery.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reneg.debtsquery.domain.entity.Debt;
import com.reneg.debtsquery.repository.DebtRepository;

@Service
public class DebtBusiness {
	
	@Autowired
	private DebtRepository debtRepository;
	
	public List<Debt> getDebitByAccount(String account) {
		return this.debtRepository.findByAccount(account);
	}
	
	public List<Debt> getDebitByIdIn(List<Long> ids) {
		return this.debtRepository.findByIdIn(ids);
	}

}
