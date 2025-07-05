package za.ac.youthVend.factory;

import org.junit.jupiter.api.Test;
import za.ac.youthVend.domain.Business;
import za.ac.youthVend.domain.Seller;

import static org.junit.jupiter.api.Assertions.*;

class BusinessFactoryTest {
    @Test
    void testCreateBusiness() {
        Seller seller = new Seller.Builder()
                .setUserId(3L)
                .setEmail("biz@youthvend.com")
                .setFullName("Business Owner")
                .setPassword("bizpass")
                .build();

        Business business = BusinessFactory.createBusiness("YouthBiz", "Selling youth fashion", seller);

        assertNotNull(business);
        assertEquals("YouthBiz", business.getBusinessName());
        assertEquals("Selling youth fashion", business.getDescription());
        assertEquals(seller, business.getSeller());
    }
}