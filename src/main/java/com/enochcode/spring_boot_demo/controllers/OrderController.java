package com.enochcode.spring_boot_demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enochcode.spring_boot_demo.dto.CreateOrderRequest;
import com.enochcode.spring_boot_demo.dto.OrderCreated;
import com.enochcode.spring_boot_demo.entity.Order;
import com.enochcode.spring_boot_demo.services.OrderService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest orderRequest) {
		OrderCreated orderCreated = orderService.createOrder(orderRequest);
		return ResponseEntity.ok(orderCreated);
	}

	@GetMapping("/{referanceId}")
	public ResponseEntity<?> getOrder(@PathVariable String referanceId) {
		Order order = orderService.getOrder(referanceId);
		return ResponseEntity.ok(order);

	}

}
