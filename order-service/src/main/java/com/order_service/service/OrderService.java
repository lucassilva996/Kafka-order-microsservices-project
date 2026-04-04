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