package com.payment_service.event;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Data
public class OrderCreatedEvent {
    private Long orderId;
    private String product;
    private Integer quantity;
}