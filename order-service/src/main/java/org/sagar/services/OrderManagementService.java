package org.sagar.services;

import java.util.Optional;

import org.sagar.dto.CancelOrderResponse;
import org.sagar.dto.PlaceOrderRequest;
import org.sagar.dto.PlaceOrderResponse;
import org.sagar.entity.Orders;
import org.sagar.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManagementService {

	@Autowired
	OrderRepository orderRepo;

	public PlaceOrderResponse placeOrder(PlaceOrderRequest request) {
		PlaceOrderResponse response = new PlaceOrderResponse();

		Orders order = new Orders();

		order.setOrderId(request.getOrderId());
		order.setProductIds(request.getProductIds());
		order.setQuantity(request.getQuentity());
		order.setPrice(request.getPrice());

		order = orderRepo.save(order);

		response.setMessage("Ordered Placed Successfully");
		response.setOrderId(order.getOrderId());
		response.setProductIds(request.getProductIds());
		response.setQuentity(request.getQuentity());
		response.setTotalPrice(request.getPrice());

		return response;
	}

	public CancelOrderResponse cancelOrder(Long orderId) {
		CancelOrderResponse response = new CancelOrderResponse();

		Optional<Orders> orderToDelete = orderRepo.findById(orderId);

		if (orderToDelete.isEmpty()) {
			response.setMessage("No order found");
		}
		else
		{
			Orders order = orderToDelete.get();
    		orderRepo.delete(order);
    		response.setOrderId(order.getOrderId());
    		response.setMessage("Order canceled Successfully");
		}
		
		return response;
	}
}
