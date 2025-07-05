package za.ac.youthVend.factory;

import za.ac.youthVend.domain.Buyer;

import za.ac.youthVend.domain.Order;
import za.ac.youthVend.domain.Products;
import za.ac.youthVend.util.Helper;

import java.time.LocalDate;

public class OrderFactory {
    public static Order createOrder(Buyer buyer, Products product, int quantity, LocalDate orderDate) {
        if (buyer == null || product == null || quantity <= 0 || !Helper.isDate(orderDate)) {
            return null;
        }

        return new Order.Builder()
                .setBuyer(buyer)
                .setProduct(product)
                .setQuantity(quantity)
                .setOrderDate(orderDate)
                .build();
    }
}
