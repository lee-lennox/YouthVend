package za.ac.youthVend.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Business;
import za.ac.youthVend.domain.Seller;
import za.ac.youthVend.factory.BusinessFactory;
import za.ac.youthVend.factory.SellerFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BusinessControllerTest {

    @Autowired
    private BusinessController businessController;

    @Autowired
    private SellerController sellerController;

    private static Seller seller = SellerFactory.createSeller(
            "Business Owner",
            "biz@youthvend.com",
            "bizpass",
            "YouthBiz",
            true
    );

    private static Business business;
    private static Long savedBusinessId;

    @Test
    @Order(1)
    void createBusiness() {
        // First, save the seller
        Seller savedSeller = sellerController.createSeller(seller);
        assertNotNull(savedSeller);
        assertNotNull(savedSeller.getUserId());

        // Create and save the business using the saved seller
        business = BusinessFactory.createBusiness(
                "YouthBiz",
                "Selling youth fashion",
                savedSeller
        );

        Business created = businessController.createBusiness(business);
        assertNotNull(created);
        assertEquals("YouthBiz", created.getBusinessName());
        savedBusinessId = created.getBusinessId();
        System.out.println("Created Business: " + created);
    }

    @Test
    @Order(2)
    void readBusiness() {
        Business found = businessController.readBusiness(savedBusinessId);
        assertNotNull(found);
        assertEquals(business.getBusinessName(), found.getBusinessName());
        System.out.println("Read Business: " + found);
    }

    @Test
    @Order(3)
    void findByBusinessName() {
        Optional<Business> found = businessController.findByBusinessName(business.getBusinessName());
        assertTrue(found.isPresent());
        assertEquals(business.getBusinessName(), found.get().getBusinessName());
        System.out.println("Found Business by name: " + found.get());
    }

    @Test
    @Order(4)
    void updateBusiness() {
        Business updated = new Business.Builder()
                .copy(business)
                .setBusinessId(savedBusinessId)
                .setDescription("Updated fashion for youth")
                .build();

        Business result = businessController.updateBusiness(updated);
        assertNotNull(result);
        assertEquals("Updated fashion for youth", result.getDescription());
        System.out.println("Updated Business: " + result);
    }

    @Test
    @Order(5)
    void deleteBusiness() {
        businessController.deleteBusiness(savedBusinessId);
        Business deleted = businessController.readBusiness(savedBusinessId);
        assertNull(deleted);
        System.out.println("Deleted Business with ID: " + savedBusinessId);
    }
}
