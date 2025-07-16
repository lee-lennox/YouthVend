package za.ac.youthVend.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Products;
import za.ac.youthVend.domain.Seller;
import za.ac.youthVend.factory.ProductFactory;
import za.ac.youthVend.factory.SellerFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private SellerService sellerService;

    private static Seller seller;
    private static Products product;

    @Test
    @Order(1)
    void a_create() {
        seller = sellerService.save(
                SellerFactory.createSeller("Lebo Mo", "seller@youthvend.com", "password123", "Lebo Styles", true)
        );
        assertNotNull(seller);
        assertNotNull(seller.getUserId());

        product = ProductFactory.createProduct(
                "Youth Shoes", "High-quality sneakers", 500.0, 10, seller
        );
        assertNotNull(product);

        Products created = productService.save(product);
        assertNotNull(created);
        assertNotNull(created.getProductId());
        System.out.println(" Created: " + created);
    }

}