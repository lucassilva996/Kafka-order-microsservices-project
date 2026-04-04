@Data
public class OrderCreatedEvent {
    private Long orderId;
    private String product;
    private Integer quantity;
}