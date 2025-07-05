package za.ac.youthVend.domain;

import jakarta.persistence.*;

@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long businessId;

    private String businessName;
    private String description;

    @OneToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    protected Business() {}

    private Business(Builder builder) {
        this.businessId = builder.businessId;
        this.businessName = builder.businessName;
        this.description = builder.description;
        this.seller = builder.seller;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getDescription() {
        return description;
    }

    public Seller getSeller() {
        return seller;
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessId=" + businessId +
                ", businessName='" + businessName + '\'' +
                ", description='" + description + '\'' +
                ", seller=" + (seller != null ? seller.getUserId() : null) +
                '}';
    }

    public static class Builder {
        private Long businessId;
        private String businessName;
        private String description;
        private Seller seller;

        public Builder setBusinessId(Long businessId) {
            this.businessId = businessId;
            return this;
        }

        public Builder setBusinessName(String businessName) {
            this.businessName = businessName;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setSeller(Seller seller) {
            this.seller = seller;
            return this;
        }

        public Builder copy(Business business) {
            this.businessId = business.businessId;
            this.businessName = business.businessName;
            this.description = business.description;
            this.seller = business.seller;
            return this;
        }

        public Business build() {
            return new Business(this);
        }
    }
}