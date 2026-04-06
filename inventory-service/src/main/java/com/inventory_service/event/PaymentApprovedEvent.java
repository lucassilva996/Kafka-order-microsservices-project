package com.inventory_service.event;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Data
public class PaymentApprovedEvent {
    private Long orderId;
    private String status;
}