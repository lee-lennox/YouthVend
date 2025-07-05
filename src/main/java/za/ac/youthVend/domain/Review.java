package za.ac.youthVend.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String comment;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    protected Review() {}

    private Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.comment = builder.comment;
        this.rating = builder.rating;
        this.buyer = builder.buyer;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                ", buyer=" + (buyer != null ? buyer.getUserId() : null) +
                '}';
    }

    public static class Builder {
        private Long reviewId;
        private String comment;
        private int rating;
        private Buyer buyer;

        public Builder setReviewId(Long reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder setBuyer(Buyer buyer) {
            this.buyer = buyer;
            return this;
        }

        public Builder copy(Review review) {
            this.reviewId = review.reviewId;
            this.comment = review.comment;
            this.rating = review.rating;
            this.buyer = review.buyer;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}