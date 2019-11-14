package com.shopmart.service.order.dao;

import com.shopmart.service.order.handler.OrderNotFoundException;
import com.shopmart.service.order.model.Order;
import com.shopmart.service.order.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderDao {
    private OrderRepository orderRepository;

    public OrderDao(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrder(String transId) throws OrderNotFoundException {
        Optional<Order> byId = orderRepository.findById(transId);
        if (byId.isPresent())
            return byId.get();
        else
            throw new OrderNotFoundException("Invalid Transaction id");
    }
}
