package za.ac.youthVend.factory;

import org.junit.jupiter.api.Test;
import za.ac.youthVend.domain.Seller;

import static org.junit.jupiter.api.Assertions.*;

class SellerFactoryTest {
    @Test
    void testCreateSeller() {
        Seller seller = SellerFactory.createSeller(
                "Lebo Mo",
                "seller@youthvend.com",
                "password123",
                "Lebo Styles",
                true
        );

        assertNotNull(seller);
        assertEquals("seller@youthvend.com", seller.getEmail());
        assertEquals("Lebo Mo", seller.getFullName());
        assertEquals("password123", seller.getPassword());
        assertEquals("Lebo Styles", seller.getBusinessName());
        assertTrue(seller.isVerified());
    }
}