package com.reneg.productsquery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reneg.productsquery.business.ProductBusiness;
import com.reneg.productsquery.domain.entity.Product;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductBusiness productBusiness;
		
	@GetMapping()
	public ResponseEntity<List<Product>> findByAccount() {  
		return ResponseEntity.ok(this.productBusiness.findAll());			
	}

}
