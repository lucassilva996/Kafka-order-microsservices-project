package com.order_service.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.order_service.entity.Order;
import com.order_service.service.OrderService;
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping
    public Order create(@RequestBody Order order) {

        return service.create(order);

    }
}