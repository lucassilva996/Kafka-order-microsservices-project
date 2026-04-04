@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderCreatedEvent {
    private Long orderId;
    private String product;
    private Integer quantity;
}