package za.ac.youthVend.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderServiceTest {

    @Autowired private OrderService orderService;
    @Autowired private BuyerService buyerService;
    @Autowired private ProductService productService;
    @Autowired private SellerService sellerService;

    @Test

    void a_create() {
        // Create and save seller
        Seller seller = SellerFactory.createSeller("Mpho M", "mpho@sell.com", "pass123", "Mpho Store", true);
        assertNotNull(seller);
        Seller savedSeller = sellerService.save(seller);

        Products product = ProductFactory.createProduct("Laptop", "Gaming laptop", 15000.0, 5, savedSeller);
        assertNotNull(product);
        Products savedProduct = productService.save(product);

        // Create and save buyer
        Buyer buyer = BuyerFactory.createBuyer("buyer@youthvend.com", null, "Buyer Name");
        assertNotNull(buyer);
        Buyer savedBuyer = buyerService.save(buyer);

        // Create and save order
        Order order = OrderFactory.createOrder(savedBuyer, savedProduct, 2, LocalDate.now());
        assertNotNull(order);
        Order savedOrder = orderService.save(order);

        // Verify
        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getOrderId());
        System.out.println(" Order Created: " + savedOrder);
    }
}