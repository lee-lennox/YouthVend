package za.ac.youthVend.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Products;
import za.ac.youthVend.domain.Seller;
import za.ac.youthVend.factory.ProductFactory;
import za.ac.youthVend.factory.SellerFactory;

import java.util.List;

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
        // Create and save seller first
        seller = sellerService.save(
                SellerFactory.createSeller("Lebo Mo", "seller@youthvend.com", "password123", "Lebo Styles", true)
        );
        assertNotNull(seller);
        assertNotNull(seller.getUserId());

        // Create product linked to seller
        product = ProductFactory.createProduct(
                "Youth Shoes", "High-quality sneakers", 500.0, 10, seller
        );
        assertNotNull(product);

        // Save product
        Products created = productService.save(product);
        assertNotNull(created);
        assertNotNull(created.getProductId());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void b_read() {
        assertNotNull(product);
        Products read = productService.read(product.getProductId());
        assertNotNull(read);
        assertEquals(product.getProductId(), read.getProductId());
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void c_update() {
        Products updated = new Products.Builder()
                .copy(product)
                .setPrice(600.0)
                .build();

        Products result = productService.update(updated);
        assertNotNull(result);
        assertEquals(600.0, result.getPrice());
        System.out.println("Updated: " + result);
    }

    @Test
    @Order(4)
    void d_findByNameContainingIgnoreCase() {
        List<Products> found = productService.findByNameContainingIgnoreCase("shoes");
        assertFalse(found.isEmpty());
        System.out.println("Found by name containing 'shoes': " + found);
    }

    @Test
    @Order(5)
    void e_findBySellerId() {
        List<Products> found = productService.findBySellerId(seller.getUserId());
        assertFalse(found.isEmpty());
        System.out.println("Found by seller ID: " + found);
    }

    @Test
    @Order(6)
    void f_delete() {
        productService.deleteById(product.getProductId());
        Products deleted = productService.read(product.getProductId());
        assertNull(deleted);
        System.out.println("Deleted product with ID: " + product.getProductId());
    }
}
