package za.ac.youthVend.factory;

import org.junit.jupiter.api.Test;
import za.ac.youthVend.domain.Buyer;

import static org.junit.jupiter.api.Assertions.*;

class BuyerFactoryTest {
    @Test
    void testCreateBuyer() {
        Buyer buyer = BuyerFactory.createBuyer("buyer@youthvend.com", 4L, "Youth Buyer", "securepass");

        assertNotNull(buyer); // ✅ will pass
        assertEquals("buyer@youthvend.com", buyer.getEmail());
        assertEquals(4L, buyer.getUserId());
        assertEquals("Youth Buyer", buyer.getFullName());
        assertEquals("securepass", buyer.getPassword());
    }
}