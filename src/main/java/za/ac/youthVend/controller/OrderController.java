package za.ac.youthVend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.youthVend.domain.Order;
import za.ac.youthVend.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @GetMapping("/read/{id}")
    public Order readOrder(@PathVariable Long id) {
        return orderService.read(id);
    }

    @PostMapping("/update")
    public Order updateOrder(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/buyer/{buyerId}")
    public List<Order> findByBuyerId(@PathVariable Long buyerId) {
        return orderService.findByBuyerId(buyerId);
    }
}
