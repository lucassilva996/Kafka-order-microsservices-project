package com.payment_service.event;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentApprovedEvent {
    private Long orderId;
    private String status;
}