package com.inventory_service.consumer;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.inventory_service.event.PaymentApprovedEvent;
import com.inventory_service.event.OrderCompletedEvent;
@Component
@RequiredArgsConstructor
public class InventoryConsumer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(
        topics = "payment-approved",
        groupId = "inventory-group"
    )
    public void consume(PaymentApprovedEvent event){
        System.out.println("Reservando estoque do pedido: "
                + event.getOrderId());

        OrderCompletedEvent completed =
                new OrderCompletedEvent(
                        event.getOrderId(),
                        "Pedido finalizado com sucesso!"
                );
        kafkaTemplate.send("order-completed", completed);
    }
}