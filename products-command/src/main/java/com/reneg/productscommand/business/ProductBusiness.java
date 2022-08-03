package com.reneg.productscommand.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reneg.productscommand.domain.entity.Product;
import com.reneg.productscommand.repository.ProductRepository;

@Service
public class ProductBusiness {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product save(Product product) {
		return this.productRepository.save(product);
	}
	
	public void delete(Long id) {
		this.productRepository.deleteById(id);
	}

}
