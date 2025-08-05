package za.ac.youthVend.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Seller;
import za.ac.youthVend.factory.SellerFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SellerControllerTest {

    @Autowired
    private SellerController sellerController;

    private static Seller seller = SellerFactory.createSeller(
            "Lebo Mo",
            "seller@youthvend.com",
            "password123",
            "Lebo Styles",
            true
    );

    private static Long savedSellerId;

    @Test
    @Order(1)
    void createSeller() {
        Seller created = sellerController.createSeller(seller);
        assertNotNull(created);
        assertEquals(seller.getEmail(), created.getEmail());
        savedSellerId = created.getUserId(); // assuming getId() returns Long
        System.out.println("Created Seller: " + created);
    }

    @Test
    @Order(2)
    void readSeller() {
        Seller found = sellerController.readSeller(savedSellerId);
        assertNotNull(found);
        assertEquals(seller.getFullName(), found.getFullName());
        System.out.println("Read Seller: " + found);
    }

    @Test
    @Order(3)
    void findByBusinessName() {
        Optional<Seller> found = sellerController.findByBusinessName(seller.getBusinessName());
        assertTrue(found.isPresent());
        assertEquals(seller.getBusinessName(), found.get().getBusinessName());
        System.out.println("Found Seller by businessName: " + found.get());
    }

    @Test
    @Order(4)
    void updateSeller() {
        Seller updatedSeller = new Seller.Builder()
                .copy(seller)
                .setUserId(savedSellerId) // make sure to set the ID for update
                .setFullName("Lebo Mokoena")
                .build();

        Seller updated = sellerController.updateSeller(updatedSeller);
        assertNotNull(updated);
        assertEquals("Lebo Mokoena", updated.getFullName());
        System.out.println("Updated Seller: " + updated);
    }

    @Test
    @Order(5)
    void deleteSeller() {
        sellerController.deleteSeller(savedSellerId);
        Seller deleted = sellerController.readSeller(savedSellerId);
        assertNull(deleted);
        System.out.println("Deleted Seller with ID: " + savedSellerId);
    }
}
