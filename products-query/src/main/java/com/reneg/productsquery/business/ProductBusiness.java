package com.reneg.productsquery.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reneg.productsquery.domain.entity.Product;
import com.reneg.productsquery.repository.ProductRepository;

@Service
public class ProductBusiness {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return (List<Product>) this.productRepository.findAll();
	}

}
