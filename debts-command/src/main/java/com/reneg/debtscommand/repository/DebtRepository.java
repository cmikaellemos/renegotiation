package com.reneg.debtscommand.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.reneg.debtscommand.domain.entity.Debt;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface DebtRepository extends CrudRepository<Debt, Long> {

}
