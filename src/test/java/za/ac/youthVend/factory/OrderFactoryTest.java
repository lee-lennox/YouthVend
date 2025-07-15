package za.ac.youthVend.factory;

import org.junit.jupiter.api.Test;
import za.ac.youthVend.domain.Buyer;
import za.ac.youthVend.domain.Order;
import za.ac.youthVend.domain.Products;
import za.ac.youthVend.domain.Seller;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {
    @Test
    void testCreateOrder() {
        Seller seller = new Seller.Builder()
                .setEmail("seller@youthvend.com")
                .setUserId(1L)
                .setFullName("Seller Man")
                .setPassword("securePass")
                .setBusinessName("Youth Street Wear")
                .setVerified(true)
                .build();

        Buyer buyer = new Buyer.Builder()
                .setEmail("buyer@youthvend.com")

                .setFullName("Buyer Gal")
                .setPassword("buy123")
                .build();

        Products product = new Products.Builder()
                .setName("Sneakers")
                .setDescription("Cool running shoes")
                .setPrice(850.0)
                .setStock(5)
                .setSeller(seller)
                .build();

        Order order = OrderFactory.createOrder(buyer, product, 2, LocalDate.now());

        assertNotNull(order);
        assertEquals(buyer, order.getBuyer());
        assertEquals(product, order.getProduct());
        assertEquals(2, order.getQuantity());
        assertNotNull(order.getOrderDate());
    }
}