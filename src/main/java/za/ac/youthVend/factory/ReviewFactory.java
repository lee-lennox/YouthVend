package za.ac.youthVend.factory;

import za.ac.youthVend.domain.Buyer;
import za.ac.youthVend.domain.Review;
import za.ac.youthVend.util.Helper;

public class ReviewFactory {
    public static Review createReview(String comment, int rating, Buyer buyer) {
        if (Helper.isNullOrEmpty(comment) || !Helper.isValidRating(rating) || buyer == null) {
            return null;
        }

        return new Review.Builder()
                .setComment(comment)
                .setRating(rating)
                .setBuyer(buyer)
                .build();
    }
}
