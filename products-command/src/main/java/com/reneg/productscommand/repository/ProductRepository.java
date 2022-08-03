package com.reneg.productscommand.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.reneg.productscommand.domain.entity.Product;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface ProductRepository extends CrudRepository<Product, Long> {

}
