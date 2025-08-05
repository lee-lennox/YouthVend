package za.ac.youthVend.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.*;
import za.ac.youthVend.domain.Order;
import za.ac.youthVend.factory.BuyerFactory;
import za.ac.youthVend.factory.OrderFactory;
import za.ac.youthVend.factory.ProductFactory;
import za.ac.youthVend.factory.SellerFactory;
import za.ac.youthVend.service.BuyerService;
import za.ac.youthVend.service.ProductService;
import za.ac.youthVend.service.SellerService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderControllerTest {

    @Autowired
    private OrderController orderController;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private BuyerService buyerService;

    @Autowired
    private ProductService productsService;

    private static Seller seller;
    private static Buyer buyer;
    private static Products product;
    private static Order order;
    private static Long savedOrderId;

    @Test

    void setupEntities() {
        // Save seller
        seller = SellerFactory.createSeller(
                "Seller Man",
                "seller@youthvend.com",
                "securePass",
                "Youth Street Wear",
                true
        );
        seller = sellerService.save(seller);
        assertNotNull(seller.getUserId());

        // Save buyer
        buyer = BuyerFactory.createBuyer(
                "Buyer Gal",
                "buyer@youthvend.com",
                "buy123"
        );
        buyer = buyerService.save(buyer);
        assertNotNull(buyer.getUserId());

        // Save product
        product = ProductFactory.createProduct(
                "Sneakers",
                "Cool running shoes",
                850.0,
                10,
                seller
        );
        product = productsService.save(product);
        assertNotNull(product.getProductId());
    }

    @Test

    void createOrder() {
        order = OrderFactory.createOrder(buyer, product, 2, LocalDate.now());
        Order created = orderController.createOrder(order);
        assertNotNull(created);
        savedOrderId = created.getOrderId();
        assertEquals(order.getQuantity(), created.getQuantity());
        System.out.println("Created Order: " + created);
    }

    @Test

    void readOrder() {
        Order found = orderController.readOrder(savedOrderId);
        assertNotNull(found);
        assertEquals(order.getQuantity(), found.getQuantity());
        System.out.println("Read Order: " + found);
    }

    @Test

    void updateOrder() {
        Order updatedOrder = new Order.Builder()
                .copy(order)
                .setOrderId(savedOrderId)
                .setQuantity(3)
                .build();
        Order updated = orderController.updateOrder(updatedOrder);
        assertNotNull(updated);
        assertEquals(3, updated.getQuantity());
        System.out.println("Updated Order: " + updated);
    }

    @Test

    void findByBuyerId() {
        List<Order> orders = orderController.findByBuyerId(buyer.getUserId());
        assertFalse(orders.isEmpty());
        System.out.println("Orders by Buyer: " + orders);
    }

    @Test

    void getAllOrders() {
        List<Order> orders = orderController.getAllOrders();
        assertFalse(orders.isEmpty());
        System.out.println("All Orders: " + orders);
    }

    @Test

    void deleteOrder() {
        assertNotNull(savedOrderId, "Cannot delete: savedOrderId is null");

        orderController.deleteOrder(savedOrderId);
        Order deleted = orderController.readOrder(savedOrderId);
        assertNull(deleted, "Order should be null after deletion");

        System.out.println("Deleted Order ID: " + savedOrderId);
    }

}
