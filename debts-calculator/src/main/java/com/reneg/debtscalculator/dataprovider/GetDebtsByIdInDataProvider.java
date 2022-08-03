package com.reneg.debtscalculator.dataprovider;

import java.util.List;

import com.reneg.debtscalculator.domain.dto.Debt;

public interface GetDebtsByIdInDataProvider {
	
	public List<Debt> getDebtsByIdIn(List<Long> ids);

}
