package org.sagar.controller;

import org.sagar.dto.CancelOrderResponse;
import org.sagar.dto.PlaceOrderRequest;
import org.sagar.dto.PlaceOrderResponse;
import org.sagar.services.OrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderManagementController {

	@Autowired
	OrderManagementService orderService;
	
	@PostMapping(path = "/api/v1/order/place")
	public PlaceOrderResponse placeOrderService(@RequestBody PlaceOrderRequest orderRequest) {
		return orderService.placeOrder(orderRequest);
			
	}
	
	@DeleteMapping(path = "/api/v1/order/delete/{orderId}")
	public CancelOrderResponse CancelOrderServive(@PathVariable Long orderId) {
		
		return orderService.cancelOrder(orderId);
	}
}
