package za.ac.youthVend.factory;

import org.junit.jupiter.api.Test;
import za.ac.youthVend.domain.Buyer;
import za.ac.youthVend.domain.Review;

import static org.junit.jupiter.api.Assertions.*;

class ReviewFactoryTest {
    @Test
    void testCreateReview() {
        Buyer buyer = new Buyer.Builder()

                .setEmail("buyer@youthvend.com")
                .setFullName("Buyer One")
                .setPassword("buyerpass")
                .build();

        Review review = ReviewFactory.createReview("Great product!", 5, buyer);

        assertNotNull(review);
        assertEquals("Great product!", review.getComment());
        assertEquals(5, review.getRating());
        assertEquals(buyer, review.getBuyer());
    }
}