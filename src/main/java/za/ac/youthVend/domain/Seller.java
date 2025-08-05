package za.ac.youthVend.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Seller extends User {
    private String businessName;
    private boolean verified;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Products> products;

    public Seller(Builder builder) {
        super(builder.email,  builder.fullName, builder.password);
        this.businessName = builder.businessName;
        this.verified = builder.verified;
    }

    protected Seller() {}

    public String getBusinessName() {
        return businessName;
    }

    public boolean isVerified() {
        return verified;
    }

    public List<Products> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "businessName='" + businessName + '\'' +
                ", verified=" + verified +
                ", userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        private String businessName;
        private boolean verified;
        private String email;
        private Long userId;
        private String fullName;
        private String password;

        public Builder setBusinessName(String businessName) {
            this.businessName = businessName;
            return this;
        }

        public Builder setVerified(boolean verified) {
            this.verified = verified;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(Seller seller) {
            this.businessName = seller.businessName;
            this.verified = seller.verified;
            this.email = seller.email;
            this.userId = seller.userId;
            this.fullName = seller.fullName;
            this.password = seller.password;
            return this;
        }

        public Seller build() {
            return new Seller(this);
        }
    }
}