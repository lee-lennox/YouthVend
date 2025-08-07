package za.ac.youthVend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.youthVend.domain.Review;
import za.ac.youthVend.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    public Review createReview(@RequestBody Review review) {
        return reviewService.save(review);
    }

    @GetMapping("/read/{id}")
    public Review readReview(@PathVariable Long id) {
        return reviewService.read(id);
    }

    @PostMapping("/update")
    public Review updateReview(@RequestBody Review review) {
        return reviewService.save(review);
    }

    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/rating/{rating}")
    public List<Review> findByRating(@PathVariable int rating) {
        return reviewService.findByRating(rating);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteById(id);
    }
}

