package za.ac.youthVend.factory;

import org.junit.jupiter.api.Test;
import za.ac.youthVend.domain.Products;
import za.ac.youthVend.domain.Seller;

import static org.junit.jupiter.api.Assertions.*;

public class ProductFactoryTest {

    @Test
    void testCreateProduct() {
        Seller seller = new Seller.Builder()
                .setUserId(1L)
                .setEmail("seller@youthvend.com")
                .setFullName("Youth Seller")
                .setPassword("pass123")
                .build();

        Products product = ProductFactory.createProduct(
                "Youth Shoes", "High-quality sneakers", 500.0, 10, seller);

        assertNotNull(product);
        assertEquals("Youth Shoes", product.getName());
        assertEquals("High-quality sneakers", product.getDescription());
        assertEquals(500.0, product.getPrice());
        assertEquals(10, product.getStock());
        assertEquals(seller, product.getSeller());
    }
}