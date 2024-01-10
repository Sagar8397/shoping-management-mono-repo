package org.sagar.controller;

import org.sagar.dto.ProductRequest;
import org.sagar.dto.ProductResponse;
import org.sagar.services.ProductManagementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductManagementController {

	ProductManagementService productService;
	
	@PostMapping(path = "/api/v1/product/add/update")
	public ProductResponse productService(@RequestBody ProductRequest productRequest) {

		return productService.addProduct(productRequest);
	}
}
