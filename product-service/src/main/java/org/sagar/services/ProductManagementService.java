package org.sagar.services;

import org.sagar.dto.ProductRequest;
import org.sagar.dto.ProductResponse;
import org.sagar.entity.Product;
import org.sagar.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductManagementService {

	@Autowired
	ProductRepository repo;

	public ProductResponse addProduct(ProductRequest request)
	{
		ProductResponse response = new ProductResponse();

		Product product = new Product();

		if(request.getProductName().isEmpty())
		{
			response.setStatus("Unsuccess");
			response.setMessage("Product data not found");
		}
		else
		{
			product.setProductName(request.getProductName());
			product.setPrice(request.getPrice());
			product.setQuentity(request.getQuantity());
			
			product = repo.save(product);
			
			response.setStatus("Success");
			response.setMessage("Product added successfull");
		}
		
		return response;
	}
}
