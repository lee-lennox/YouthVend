package za.ac.youthVend.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private int quantity;
    private LocalDate orderDate;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    public Order(Builder builder) {
        this.orderId = builder.orderId;
        this.quantity = builder.quantity;
        this.orderDate = builder.orderDate;
        this.totalPrice = builder.totalPrice;
        this.buyer = builder.buyer;
        this.product = builder.product;
    }

    protected Order() {}

    public Long getOrderId() {
        return orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Products getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", buyer=" + (buyer != null ? buyer.getUserId() : null) +
                ", product=" + (product != null ? product.getProductId() : null) +
                '}';
    }

    public static class Builder {
        private Long orderId;
        private int quantity;
        private LocalDate orderDate;
        private double totalPrice;
        private Buyer buyer;
        private Products product;

        public Builder setOrderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder setBuyer(Buyer buyer) {
            this.buyer = buyer;
            return this;
        }

        public Builder setProduct(Products product) {
            this.product = product;
            return this;
        }

        public Builder copy(Order order) {
            this.orderId = order.orderId;
            this.quantity = order.quantity;
            this.orderDate = order.orderDate;
            this.totalPrice = order.totalPrice;
            this.buyer = order.buyer;
            this.product = order.product;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
