package com.reneg.productscommand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reneg.productscommand.business.ProductBusiness;
import com.reneg.productscommand.domain.entity.Product;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductBusiness productBusiness;
		
	@PostMapping
	public Product save(@RequestBody Product product){
		return this.productBusiness.save(product);
	}
	
	@PutMapping
	public Product update(@RequestBody Product product){
		return this.productBusiness.save(product);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		this.productBusiness.delete(id);
		return ResponseEntity.noContent().build();
	}

}
