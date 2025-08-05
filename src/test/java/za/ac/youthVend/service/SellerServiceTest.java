package za.ac.youthVend.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Seller;
import za.ac.youthVend.factory.SellerFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class SellerServiceTest {

    @Autowired
    private SellerService sellerService;

    private static Seller savedSeller;

    @Test
    @Order(1)
    void a_create() {
        Seller seller = SellerFactory.createSeller(
                "Lebo Mo",
                "seller@youthvend.com",
                "password123",
                "Lebo Styles",
                true
        );

        assertNotNull(seller);

        savedSeller = sellerService.save(seller);
        assertNotNull(savedSeller);
        assertNotNull(savedSeller.getUserId());
        System.out.println("Seller Created: " + savedSeller);
    }

    @Test
    @Order(2)
    void b_read() {
        assertNotNull(savedSeller);
        Seller readSeller = sellerService.read(savedSeller.getUserId());
        assertNotNull(readSeller);
        assertEquals(savedSeller.getUserId(), readSeller.getUserId());
        System.out.println("Seller Read: " + readSeller);
    }

    @Test
    @Order(3)
    void c_update() {
        Seller updated = new Seller.Builder()
                .copy(savedSeller)
                .setBusinessName("Updated Business")
                .build();

        Seller result = sellerService.update(updated);
        assertNotNull(result);
        assertEquals("Updated Business", result.getBusinessName());
        System.out.println("Seller Updated: " + result);
    }

    @Test
    @Order(4)
    void d_findByBusinessName() {
        Optional<Seller> found = sellerService.findByBusinessName("Updated Business");
        assertTrue(found.isPresent());
        System.out.println("Seller Found By Business Name: " + found.get());
    }

    @Test
    @Order(5)
    void e_delete() {
        assertNotNull(savedSeller);
        sellerService.deleteById(savedSeller.getUserId());

        Seller deleted = sellerService.read(savedSeller.getUserId());
        assertNull(deleted);
        System.out.println("Seller Deleted with ID: " + savedSeller.getUserId());
    }
}
