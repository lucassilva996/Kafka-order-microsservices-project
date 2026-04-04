@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }
}