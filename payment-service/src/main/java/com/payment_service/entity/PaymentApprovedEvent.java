@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentApprovedEvent {
    private Long orderId;
    private String status;
}