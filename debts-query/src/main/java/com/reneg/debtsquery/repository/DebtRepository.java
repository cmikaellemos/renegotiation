package com.reneg.debtsquery.repository;

import com.reneg.debtsquery.domain.entity.Debt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface DebtRepository extends CrudRepository<Debt, Long> {

    List<Debt> findByAccount(String account);
    
    List<Debt> findByIdIn(List<Long> ids);

}
