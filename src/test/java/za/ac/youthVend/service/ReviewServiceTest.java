package za.ac.youthVend.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.youthVend.domain.Buyer;
import za.ac.youthVend.domain.Review;
import za.ac.youthVend.factory.BuyerFactory;
import za.ac.youthVend.factory.ReviewFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private BuyerService buyerService;

    private static Buyer buyer;
    private static Review review;

    @Test
    @Order(1)
    void a_create() {
        buyer = BuyerFactory.createBuyer(
                "Zamani Madonsela",
                "Zmadonsela@gmail.com",
                "zee1234"
        );
        buyer = buyerService.save(buyer);

        // Create review using factory
        review = ReviewFactory.createReview(
                "Excellent service and quality!",
                5,
                buyer
        );
        assertNotNull(review);

        Review saved = reviewService.save(review);
        assertNotNull(saved);
        assertNotNull(saved.getReviewId());
        review = saved;  // Keep for other tests
        System.out.println("Created: " + saved);
    }

    @Test
    @Order(2)
    void b_read() {
        Review read = reviewService.read(review.getReviewId());
        assertNotNull(read, "Review should exist");
        assertEquals(review.getReviewId(), read.getReviewId());
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void c_update() {
        Review updatedReview = new Review.Builder()
                .copy(review)
                .setComment("Updated: Great experience overall.")
                .setRating(4)
                .build();

        Review updated = reviewService.save(updatedReview);
        assertNotNull(updated);
        assertEquals("Updated: Great experience overall.", updated.getComment());
        assertEquals(4, updated.getRating());
        review = updated;
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    @Disabled("Delete test disabled for safety")
    void d_delete() {
        reviewService.deleteById(review.getReviewId());
        Review deleted = reviewService.read(review.getReviewId());
        assertNull(deleted);
        System.out.println("Deleted review with ID: " + review.getReviewId());
    }

    @Test
    @Order(5)
    void e_findByRating() {
        List<Review> results = reviewService.findByRating(review.getRating());
        assertFalse(results.isEmpty(), "Should return reviews with the correct rating");
        System.out.println("Found reviews by rating: " + results);
    }
}
