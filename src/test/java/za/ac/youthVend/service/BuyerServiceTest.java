package za.ac.youthVend.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Buyer;
import za.ac.youthVend.factory.BuyerFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BuyerServiceTest {

    @Autowired
    private BuyerService buyerService;

    private static Buyer buyer;

    @BeforeAll
    static void setUp() {
        buyer = BuyerFactory.createBuyer(
                "youthbuyer@youthvend.com",
                101L,
                "Lennox Buyer",
                "pass123"
        );
    }

    @Test
    @Order(1)
    void save() {
        Buyer saved = buyerService.save(buyer);
        assertNotNull(saved);
        assertEquals(buyer.getEmail(), saved.getEmail());
        System.out.println("Saved: " + saved);
    }

    @Test
    @Order(2)
    void read() {
        Buyer read = buyerService.read(buyer.getUserId());
        assertNotNull(read);
        assertEquals(buyer.getFullName(), read.getFullName());
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        Buyer updated = new Buyer.Builder()
                .copy(buyer)
                .setFullName("Lenny Updated")
                .build();
        Buyer result = buyerService.update(updated);
        assertNotNull(result);
        assertEquals("Lenny Updated", result.getFullName());
        System.out.println("Updated: " + result);
    }

    @Test
    @Order(4)
    void findByEmail() {
        Optional<Buyer> optionalBuyer = buyerService.findByEmail(buyer.getEmail());
        assertTrue(optionalBuyer.isPresent());
        assertEquals(buyer.getEmail(), optionalBuyer.get().getEmail());
        System.out.println("Found by Email: " + optionalBuyer.get());
    }

    @Test
    @Order(5)
    void findAll() {
        List<Buyer> buyers = buyerService.findAll();
        assertFalse(buyers.isEmpty());
        System.out.println("All Buyers:");
        buyers.forEach(System.out::println);
    }

    @Test
    @Order(6)
    void deleteById() {
        buyerService.deleteById(buyer.getUserId());
        Buyer deleted = buyerService.read(buyer.getUserId());
        assertNull(deleted);
        System.out.println("Deleted buyer with ID: " + buyer.getUserId());
    }
}