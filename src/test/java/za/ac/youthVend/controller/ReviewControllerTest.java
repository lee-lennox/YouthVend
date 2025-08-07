package za.ac.youthVend.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Buyer;
import za.ac.youthVend.domain.Review;
import za.ac.youthVend.factory.BuyerFactory;
import za.ac.youthVend.factory.ReviewFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReviewControllerTest {

    @Autowired
    private ReviewController reviewController;

    @Autowired
    private BuyerController buyerController;

    private static Buyer buyer;
    private static Review review;

    @Test
    @Order(1)
    void createReview() {
        // First create a buyer to associate with the review
        buyer = BuyerFactory.createBuyer("John Doe", "johndoe@gmail.com", "john123");
        buyer = buyerController.createBuyer(buyer);

        // Now create a review for that buyer
        review = ReviewFactory.createReview(
                "These rims really improve my car’s performance.",
                5,
                buyer
        );

        Review created = reviewController.createReview(review);
        assertNotNull(created);
        assertEquals(5, created.getRating());
        review = created; // Save reference for other tests
        System.out.println("Created Review: " + created);
    }

    @Test
    @Order(2)
    void readReview() {
        Review found = reviewController.readReview(review.getReviewId());
        assertNotNull(found);
        assertEquals(review.getComment(), found.getComment());
        System.out.println("Read Review: " + found);
    }

    @Test
    @Order(3)
    void updateReview() {
        Review updated = new Review.Builder()
                .copy(review)
                .setComment("Updated comment: amazing product!")
                .build();

        Review result = reviewController.updateReview(updated);
        assertNotNull(result);
        assertEquals("Updated comment: amazing product!", result.getComment());
        System.out.println("Updated Review: " + result);
    }
}
