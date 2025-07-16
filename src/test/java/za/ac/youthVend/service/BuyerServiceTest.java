package za.ac.youthVend.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Buyer;
import za.ac.youthVend.factory.BuyerFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class BuyerServiceTest {
    @Autowired
    private BuyerService buyerService;
    private Buyer buyer = BuyerFactory.createBuyer("Lennoxy", "lee", "komane@leegmail.com");
    @Test
    @Order(1)
    void a_create() {

        Buyer created = buyerService.save(buyer);
        assertNotNull(created);
        assertNotNull(created.getUserId());
        System.out.println("Created: " + created);
    }
    @Test
    @Order(2)
    void read() {
        Optional<Buyer> optionalBuyer = buyerService.findByEmail(buyer.getEmail());
        assertTrue(optionalBuyer.isPresent(), "Buyer should be present");

        Buyer read = optionalBuyer.get();
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void c_update() {

        Buyer newBuyer = new Buyer.Builder().copy(buyer).setFullName("kman").build();
        Buyer upudate =buyerService.save(newBuyer);
        assertNotNull(upudate);
        System.out.println(upudate);

    }
    @Test
    @Disabled
    @Order(4)
    void delete() {
        Buyer saved = buyerService.save(buyer); // Ensure customer is saved
        assertNotNull(saved); // Sanity check

    }
}