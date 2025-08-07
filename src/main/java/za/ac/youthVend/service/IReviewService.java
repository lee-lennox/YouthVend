package za.ac.youthVend.service;

import za.ac.youthVend.domain.Review;

import java.util.List;

public interface IReviewService extends IService<Review, Long> {
    List<Review> findByRating(int rating);
}
