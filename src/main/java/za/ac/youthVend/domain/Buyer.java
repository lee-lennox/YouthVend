package za.ac.youthVend.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


import java.util.List;
@Entity
public class Buyer extends User {

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Buyer(Builder builder) {
        super(builder.email,  builder.fullName, builder.password);
    }


    protected Buyer() {}

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "orders=" + orders +
                ", userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        private String email;
        private String fullName;
        private String password;

        public Builder setEmail(String email) {
            this.email = email;
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

        public Builder copy(Buyer buyer) {
            this.email = buyer.email;
            this.fullName = buyer.fullName;
            this.password = buyer.password;
            return this;
        }

        public Buyer build() {
            return new Buyer(this);
        }
    }

}