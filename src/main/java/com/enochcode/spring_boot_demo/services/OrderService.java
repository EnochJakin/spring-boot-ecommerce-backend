package com.enochcode.spring_boot_demo.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enochcode.spring_boot_demo.dto.CreateOrderRequest;
import com.enochcode.spring_boot_demo.dto.OrderCreated;
import com.enochcode.spring_boot_demo.dto.OrderItemDto;
import com.enochcode.spring_boot_demo.entity.Order;
import com.enochcode.spring_boot_demo.entity.OrderItem;
import com.enochcode.spring_boot_demo.entity.Product;
import com.enochcode.spring_boot_demo.repository.OrderRepository;
import com.enochcode.spring_boot_demo.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private ProductRepository prodRepo;

	@Autowired
	private OrderRepository orderRepo;

	public OrderCreated createOrder(CreateOrderRequest orderRequest) {

		Order order = new Order();
		order.setStatus("PENDING");
		double totalItemsAmount = 0;

		for (OrderItemDto item : orderRequest.getOrderItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setName(item.getName());
			orderItem.setPrice(item.getPrice());
			orderItem.setImage(item.getImage());
			orderItem.setQuantity(item.getQuantity());

			Product product = prodRepo.findById(item.getProductId())
					.orElseThrow(() -> new RuntimeException("Product is not found"));
			orderItem.setProduct(product);
			
			orderItem.setOrder(order); // add this line

			totalItemsAmount += item.getPrice() * item.getQuantity();

			order.getOrderItems().add(orderItem);
		}
		order.setTotalItemsAmount(totalItemsAmount);
		double totalAmount = 0;
		double taxAmount = 10;

		totalAmount = totalItemsAmount + taxAmount;

		order.setTotalAmount(totalAmount);
		order.setTaxAmount(taxAmount);

		String refId = UUID.randomUUID().toString();

		order.setReferanceId(refId);

		orderRepo.save(order);
		return new OrderCreated(refId);
	}

	public Order getOrder(String referanceId) {
		return orderRepo.findByReferanceId(referanceId)
				.orElseThrow(() -> new RuntimeException("No order found in referance Id"));
	}
}