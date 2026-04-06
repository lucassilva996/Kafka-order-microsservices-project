package com.notification_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.notification_service.event.OrderCompletedEvent;
@Component
public class NotificationConsumer {

    @KafkaListener(
            topics = "order-completed",
            groupId = "notification-group"
    )
    public void consume(OrderCompletedEvent event) {

        System.out.println("📧 Enviando email...");
        System.out.println(
                "Pedido: " + event.getOrderId()
        );
        System.out.println(event.getMessage());
    }
}