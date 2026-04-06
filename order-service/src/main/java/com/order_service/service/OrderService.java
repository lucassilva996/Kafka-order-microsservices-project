package com.order_service.service;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.order_service.entity.Order;
import com.order_service.event.OrderCreatedEvent;
import com.order_service.repository.OrderRepository;
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Order create(Order order){
        order.setStatus("CREATED");
        Order saved = repository.save(order);

        OrderCreatedEvent event =
                new OrderCreatedEvent(
                        saved.getId(),
                        saved.getProduct(),
                        saved.getQuantity()
                );
        kafkaTemplate.send("order-created", event);
        return saved;
    }

}