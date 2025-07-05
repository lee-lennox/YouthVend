package za.ac.youthVend.service;

import za.ac.youthVend.domain.Order;

import java.util.List;

public interface IOrderService extends IService<Order, Long> {
    List<Order> findByBuyerId(Long buyerId);
}
