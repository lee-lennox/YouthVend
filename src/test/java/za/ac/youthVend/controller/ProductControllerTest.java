package za.ac.youthVend.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Products;
import za.ac.youthVend.domain.Seller;
import za.ac.youthVend.factory.ProductFactory;
import za.ac.youthVend.service.SellerService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @Autowired
    private SellerService sellerService;

    private static Seller savedSeller;
    private static Products product;
    private static Long savedProductId;

    @BeforeAll
    static void setup(@Autowired SellerService sellerService) {
        Seller seller = new Seller.Builder()
                .setEmail("seller@youthvend.com")
                .setFullName("Seller Man")
                .setPassword("pass123")
                .build();
        savedSeller = sellerService.save(seller);
        assertNotNull(savedSeller);
        assertNotNull(savedSeller.getUserId());
    }

    @Test
    @Order(1)
    void createProduct() {
        product = ProductFactory.createProduct(
                "Sneakers",
                "Running shoes",
                850.0,
                10,
                savedSeller
        );

        Products created = productController.createProduct(product);
        assertNotNull(created);
        assertEquals("Sneakers", created.getName());
        savedProductId = created.getProductId();
        System.out.println("Created Product: " + created);
    }

    @Test
    @Order(2)
    void readProduct() {
        Products found = productController.readProduct(savedProductId);
        assertNotNull(found);
        assertEquals(product.getName(), found.getName());
        System.out.println("Read Product: " + found);
    }

    @Test
    @Order(3)
    void updateProduct() {
        Products updatedProduct = new Products.Builder()
                .copy(product)
                .setProductId(savedProductId)
                .setName("Sneakers Updated")
                .setDescription("Updated running shoes")
                .setPrice(900.0)
                .setStock(15)
                .setSeller(savedSeller)
                .build();

        Products updated = productController.updateProduct(updatedProduct);
        assertNotNull(updated);
        assertEquals("Sneakers Updated", updated.getName());
        assertEquals(900.0, updated.getPrice());
        System.out.println("Updated Product: " + updated);
    }

    @Test
    @Order(4)
    void findBySellerId() {
        List<Products> products = productController.findBySellerId(savedSeller.getUserId());
        assertFalse(products.isEmpty());
        assertTrue(products.stream().anyMatch(p -> p.getProductId().equals(savedProductId)));
        System.out.println("Found Products by SellerId: " + products);
    }

    @Test
    @Order(5)
    void findByNameContainingIgnoreCase() {
        List<Products> products = productController.findByNameContainingIgnoreCase("sneak");
        assertFalse(products.isEmpty());
        assertTrue(products.stream()
                .anyMatch(p -> p.getName().toLowerCase().contains("sneak")));
        System.out.println("Found Products by name search: " + products);
    }

    @Test
    @Order(6)
    void deleteProduct() {
        productController.deleteProduct(savedProductId);
        Products deleted = productController.readProduct(savedProductId);
        assertNull(deleted);
        System.out.println("Deleted Product with ID: " + savedProductId);
    }
}
