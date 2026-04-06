package com.inventory_service.event;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderCompletedEvent{
    private Long orderId;
    private String message;
}