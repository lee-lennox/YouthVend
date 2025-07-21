package za.ac.youthVend.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Seller;
import za.ac.youthVend.factory.SellerFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class SellerServiceTest {

    @Autowired
    private SellerService sellerService;

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

        Seller created = sellerService.save(seller);
        assertNotNull(created);
        assertNotNull(created.getUserId());
        System.out.println(" Seller Created: " + created);
    }


}