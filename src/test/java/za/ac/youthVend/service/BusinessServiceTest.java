package za.ac.youthVend.service;

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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class BusinessServiceTest {

    @Autowired private BusinessService businessService;
    @Autowired private SellerService sellerService;

    private static Business business;
    private static Seller seller;

    @Test
    @Order(1)
    void a_create() {
        seller = SellerFactory.createSeller(
                "Neo Dlamini",
                "neo@sellmail.com",
                "securePass!",
                "Neo's Apparel",
                true
        );
        assertNotNull(seller);
        seller = sellerService.save(seller);
        assertNotNull(seller.getUserId());

        business = BusinessFactory.createBusiness(
                "Neo's Apparel Store",
                "High-quality fashion for youth.",
                seller
        );
        assertNotNull(business);
        business = businessService.save(business);
        assertNotNull(business);
        assertNotNull(business.getBusinessId());

        System.out.println("Business Created: " + business);
    }

    @Test
    @Order(2)
    void b_read() {
        assertNotNull(business);
        Business read = businessService.read(business.getBusinessId());
        assertNotNull(read);
        System.out.println("Business Read: " + read);
    }

    @Test
    @Order(3)
    void c_update() {
        assertNotNull(business);
        Business updated = new Business.Builder().copy(business)
                .setDescription("Updated description for Neo's Store.")
                .build();
        Business saved = businessService.save(updated);
        assertNotNull(saved);
        System.out.println("Business Updated: " + saved);
    }

    @Test
    @Order(4)
    void d_getAll() {
        assertNotNull(business);
        System.out.println("All Businesses: " + businessService.findAll());
    }

    @Test
    @Order(5)
    void e_delete() {

    }
}
