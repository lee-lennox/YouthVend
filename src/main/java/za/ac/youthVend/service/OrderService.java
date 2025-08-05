package za.ac.youthVend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.youthVend.domain.Order;
import za.ac.youthVend.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }



    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Order read(Long id) {
        Optional<Order> order = repository.findById(id);
        return order.orElse(null);
    }



    @Override
    public Order update(Order order) {
        return repository.save(order);
    }



    @Override
    public List<Order> findByBuyerId(Long buyerId) {
        return repository.findByBuyer_UserId(buyerId);
    }
}

