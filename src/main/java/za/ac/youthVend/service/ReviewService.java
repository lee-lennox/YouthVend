package za.ac.youthVend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.youthVend.domain.Review;
import za.ac.youthVend.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService implements IReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findByRating(int rating) {
        return reviewRepository.findByRating(rating);
    }

    @Override
    public Review save(Review entity) {
        return reviewRepository.save(entity);
    }

    @Override
    public Review update(Review entity) {
        return reviewRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review read(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}

