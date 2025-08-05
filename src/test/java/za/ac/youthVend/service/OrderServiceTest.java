package za.ac.youthVend.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Buyer;
import za.ac.youthVend.domain.Order;
import za.ac.youthVend.domain.Products;
import za.ac.youthVend.domain.Seller;
import za.ac.youthVend.factory.BuyerFactory;
import za.ac.youthVend.factory.OrderFactory;
import za.ac.youthVend.factory.ProductFactory;
import za.ac.youthVend.factory.SellerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderServiceTest {

    @Autowired private OrderService orderService;
    @Autowired private BuyerService buyerService;
    @Autowired private ProductService productService;
    @Autowired private SellerService sellerService;

    private static Order order;
    private static Buyer buyer;
    private static Products product;

    @Test
    void a_create() {
        // Create and save seller
        Seller seller = SellerFactory.createSeller("Mpho M", "mpho@sell.com", "pass123", "Mpho Store", true);
        Seller savedSeller = sellerService.save(seller);
        assertNotNull(savedSeller);

        // Create and save product
        product = ProductFactory.createProduct("Laptop", "Gaming laptop", 15000.0, 5, savedSeller);
        Products savedProduct = productService.save(product);
        assertNotNull(savedProduct);

        // Create and save buyer
        buyer = BuyerFactory.createBuyer("buyer@youthvend.com", null, "Buyer Name");
        Buyer savedBuyer = buyerService.save(buyer);
        assertNotNull(savedBuyer);

        // Create and save order
        order = OrderFactory.createOrder(savedBuyer, savedProduct, 2, LocalDate.now());
        Order savedOrder = orderService.save(order);

        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getOrderId());
        order = savedOrder; // store for other tests
        System.out.println("Created Order: " + savedOrder);
    }

    @Test
    void b_read() {
        assertNotNull(order.getOrderId());
        Order readOrder = orderService.read(order.getOrderId());
        assertNotNull(readOrder);
        assertEquals(order.getOrderId(), readOrder.getOrderId());
        System.out.println("Read Order: " + readOrder);
    }

    @Test
    void c_update() {
        Order updatedOrder = new Order.Builder()
                .copy(order)
                .setQuantity(3)
                .build();

        Order result = orderService.update(updatedOrder);
        assertNotNull(result);
        assertEquals(3, result.getQuantity());
        System.out.println("Updated Order: " + result);
    }

    @Test
    void d_findByBuyerId() {
        List<Order> orders = orderService.findByBuyerId(buyer.getUserId());
        assertFalse(orders.isEmpty());
        assertEquals(buyer.getUserId(), orders.get(0).getBuyer().getUserId());
        System.out.println("Orders by Buyer ID: " + orders);
    }

    @Test
    void e_findAll() {
        List<Order> orders = orderService.findAll();
        assertNotNull(orders);
        assertFalse(orders.isEmpty());
        System.out.println("All Orders: " + orders);
    }

    @Test
    void f_delete() {
        assertNotNull(order.getOrderId());
        orderService.deleteById(order.getOrderId());

        Order deleted = orderService.read(order.getOrderId());
        assertNull(deleted);
        System.out.println("Order deleted");
    }
}
