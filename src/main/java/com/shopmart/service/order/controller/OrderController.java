package com.shopmart.service.order.controller;

import com.shopmart.service.order.handler.InvalidPaymentDetails;
import com.shopmart.service.order.handler.OrderNotFoundException;
import com.shopmart.service.order.model.Order;
import com.shopmart.service.order.model.OrderResponse;
import com.shopmart.service.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody @Valid Order order) throws InvalidPaymentDetails {
		OrderResponse orderResponse = orderService.processOrder(order);
		return new ResponseEntity<OrderResponse>(orderResponse, HttpStatus.CREATED);
	}

	@GetMapping("/{transId}")
	public Order getOrder(@PathVariable String transId) throws OrderNotFoundException {
		return orderService.getOrderDetails(transId);
	}
}
