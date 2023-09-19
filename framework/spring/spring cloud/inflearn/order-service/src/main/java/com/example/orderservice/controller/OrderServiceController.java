package com.example.orderservice.controller;

import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.request.RequestOrder;
import com.example.orderservice.response.ResponseOrder;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.vo.OrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order-service")
public class OrderServiceController {

    Environment environment;

    OrderService orderService;

    @Autowired
    public OrderServiceController(Environment environment, OrderService orderService) {
        this.environment = environment;
        this.orderService = orderService;
    }

    @GetMapping("/health-check")
    public String healthCheck(){

        return String.format("order-service PORT %s", environment.getProperty("local.server.port"));
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(
            @PathVariable("userId") String userId, @RequestBody RequestOrder orderDetail){

        OrderDTO orderDTO = new ModelMapper().map(orderDetail, OrderDTO.class);
        orderDTO.setUserId(userId);

        ResponseOrder responseOrder = new ModelMapper().map(orderService.createOrder(orderDTO), ResponseOrder.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseOrder);
    }

    @GetMapping("/{userId}/order")
    public ResponseEntity<List<ResponseOrder>> getOrder(@PathVariable("userId") String userId){
        Iterable<OrderEntity> orderByUserId = orderService.getOrderByUserId(userId);

        List<ResponseOrder> responseOrderList = new ArrayList<>();

        orderByUserId.forEach(orderEntity -> {
            responseOrderList.add(new ModelMapper().map(orderEntity, ResponseOrder.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(responseOrderList);
    }


}
