package com.example.orderservice.service;

import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.vo.OrderDTO;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO getOrderByOrderId(String orderId);

    Iterable<OrderEntity> getOrderByUserId(String userId);
}
