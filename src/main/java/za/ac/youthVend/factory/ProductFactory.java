package za.ac.youthVend.factory;


import za.ac.youthVend.domain.Products;
import za.ac.youthVend.domain.Seller;
import za.ac.youthVend.util.Helper;

public class ProductFactory {
    public static Products createProduct(String name, String description, double price, int stock, Seller seller) {
        if (Helper.isNullOrEmpty(name)
                || Helper.isNullOrEmpty(description)
                || Helper.isNullOrZero(stock)
                || seller == null || price <= 0.0) {
            System.out.println("Invalid product details.");
            return null;
        }

        return new Products.Builder()
                .setName(name)
                .setDescription(description)
                .setPrice(price)
                .setStock(stock)
                .setSeller(seller)
                .build();
    }
}