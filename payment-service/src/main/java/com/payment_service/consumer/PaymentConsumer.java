@Component
@RequiredArgsConstructor
public class PaymentConsumer {
    private final PaymentRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(
            topics = "order-created",
            groupId = "payment-group"
    )

    public void consume(OrderCreatedEvent event){
        System.out.println("Pagamento recebido para o pedido: "
                + event.getOrderId());

        Payment payment = new Payment();
        payment.setOrderId(event.getOrderId());
        payment.setStatus("APPROVED");

        repository.save(payment);

        PaymentApprovedEvent approved =
                new PaymentApprovedEvent(
                        event.getOrderId(),
                        "APPROVED"
                );
        kafkaTemplate.send("payment-approved", approved);
    }
}