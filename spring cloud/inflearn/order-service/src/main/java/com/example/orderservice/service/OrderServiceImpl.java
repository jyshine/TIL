package com.example.orderservice.service;

import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.vo.OrderDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{

    OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {

        orderDTO.setOrderId(UUID.randomUUID().toString());
        orderDTO.setTotalPrice(orderDTO.getQty() * orderDTO.getUnitPrice());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderEntity orderEntity = modelMapper.map(orderDTO, OrderEntity.class);

        orderRepository.save(orderEntity);

        return modelMapper.map(orderEntity, OrderDTO.class);
    }

    @Override
    public OrderDTO getOrderByOrderId(String orderId) {
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId);
        return new ModelMapper().map(orderEntity, OrderDTO.class);
    }

    @Override
    public Iterable<OrderEntity> getOrderByUserId(String userId) {
        return orderRepository.findAll();
    }
}
